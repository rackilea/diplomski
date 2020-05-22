public class PdfVeryDenseMergeTool {
    public PdfVeryDenseMergeTool(PDRectangle size, float top, float bottom, float gap)
    {
        this.pageSize = size;
        this.topMargin = top;
        this.bottomMargin = bottom;
        this.gap = gap;
    }

    public void merge(OutputStream outputStream, Iterable<PDDocument> inputs) throws IOException
    {
        try
        {
            openDocument();
            for (PDDocument input: inputs)
            {
                merge(input);
            }
            if (currentContents != null) {
                currentContents.close();
                currentContents = null;
            }
            document.save(outputStream);
        }
        finally
        {
            closeDocument();
        }

    }

    void openDocument() throws IOException
    {
        document = new PDDocument();
        newPage();
    }

    void closeDocument() throws IOException
    {
        try
        {
            if (currentContents != null) {
                currentContents.close();
                currentContents = null;
            }
            document.close();
        }
        finally
        {
            this.document = null;
            this.yPosition = 0;
        }
    }

    void newPage() throws IOException
    {
        if (currentContents != null) {
            currentContents.close();
            currentContents = null;
        }
        currentPage = new PDPage(pageSize);
        document.addPage(currentPage);
        yPosition = pageSize.getUpperRightY() - topMargin;
        currentContents = new PDPageContentStream(document, currentPage);
    }

    void merge(PDDocument input) throws IOException
    {
        for (PDPage page : input.getPages())
        {
            merge(input, page);
        }
    }

    void merge(PDDocument sourceDoc, PDPage page) throws IOException
    {
        PDRectangle pageSizeToImport = page.getCropBox();

        PageVerticalAnalyzer analyzer = new PageVerticalAnalyzer(page);
        analyzer.processPage(page);
        List<Float> verticalFlips = analyzer.getVerticalFlips();
        if (verticalFlips.size() < 2)
            return;

        LayerUtility layerUtility = new LayerUtility(document);
        PDFormXObject form = layerUtility.importPageAsForm(sourceDoc, page);

        int startFlip = verticalFlips.size() - 1;
        boolean first = true;
        while (startFlip > 0)
        {
            if (!first)
                newPage();

            float freeSpace = yPosition - pageSize.getLowerLeftY() - bottomMargin;
            int endFlip = startFlip + 1;
            while ((endFlip > 1) && (verticalFlips.get(startFlip) - verticalFlips.get(endFlip - 2) < freeSpace))
                endFlip -=2;
            if (endFlip < startFlip)
            {
                float height = verticalFlips.get(startFlip) - verticalFlips.get(endFlip);

                currentContents.saveGraphicsState();
                currentContents.addRect(0, yPosition - height, pageSizeToImport.getWidth(), height);
                currentContents.clip();
                Matrix matrix = Matrix.getTranslateInstance(0, (float)(yPosition - (verticalFlips.get(startFlip) - pageSizeToImport.getLowerLeftY())));
                currentContents.transform(matrix);
                currentContents.drawForm(form);
                currentContents.restoreGraphicsState();

                yPosition -= height + gap;
                startFlip = endFlip - 1;
            }
            else if (!first) 
                throw new IllegalArgumentException(String.format("Page %s content sections too large.", page));
            first = false;
        }
    }

    PDDocument document = null;
    PDPage currentPage = null;
    PDPageContentStream currentContents = null;
    float yPosition = 0; 

    final PDRectangle pageSize;
    final float topMargin;
    final float bottomMargin;
    final float gap;
}