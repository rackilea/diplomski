try (PdfDocument pdfDocument = new PdfDocument(SOURCE_PDF_READER, TARGET_PDF_WRITER)) {
    List<Rectangle> triggerRectangles = new ArrayList<>();

    PdfCanvasEditor editor = new PdfCanvasEditor()
    {
        {
            Field field = PdfCanvasProcessor.class.getDeclaredField("textMatrix");
            field.setAccessible(true);
            textMatrixField = field;
        }

        @Override
        protected void nextOperation(PdfLiteral operator, List<PdfObject> operands) {
            try {
                recentTextMatrix = (Matrix)textMatrixField.get(this);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        protected void write(PdfCanvasProcessor processor, PdfLiteral operator, List<PdfObject> operands)
        {
            String operatorString = operator.toString();

            if (TEXT_SHOWING_OPERATORS.contains(operatorString))
            {
                Matrix matrix = null;
                try {
                    matrix = recentTextMatrix.multiply(getGraphicsState().getCtm());
                } catch (IllegalArgumentException e) {
                    throw new RuntimeException(e);
                }
                float y = matrix.get(Matrix.I32);
                if (triggerRectangles.stream().anyMatch(rect -> rect.getBottom() <= y && y <= rect.getTop())) {
                    if ("TJ".equals(operatorString))
                        operands.set(0, new PdfArray());
                    else
                        operands.set(operands.size() - 2, new PdfString(""));
                }
            }

            super.write(processor, operator, operands);
        }

        final List<String> TEXT_SHOWING_OPERATORS = Arrays.asList("Tj", "'", "\"", "TJ");
        final Field textMatrixField;
        Matrix recentTextMatrix;
    };

    for (int i = 1; i <= pdfDocument.getNumberOfPages(); i++)
    {
        PdfPage page = pdfDocument.getPage(i);
        Set<PdfName> xobjectNames = page.getResources().getResourceNames(PdfName.XObject);
        for (PdfName xobjectName : xobjectNames) {
            PdfFormXObject xobject = page.getResources().getForm(xobjectName);
            byte[] content = xobject.getPdfObject().getBytes();
            PdfResources resources = xobject.getResources();

            RegexBasedLocationExtractionStrategy regexLocator = new RegexBasedLocationExtractionStrategy("Created by:|Calendar:");
            new PdfCanvasProcessor(regexLocator).processContent(content, resources);
            triggerRectangles.clear();
            triggerRectangles.addAll(regexLocator.getResultantLocations().stream().map(loc -> loc.getRectangle()).collect(Collectors.toSet()));

            PdfCanvas pdfCanvas = new PdfCanvas(new PdfStream(), resources, pdfDocument);
            editor.editContent(content, resources, pdfCanvas);
            xobject.getPdfObject().setData(pdfCanvas.getContentStream().getBytes());
        }
    }
}