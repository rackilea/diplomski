public class PdfImageCounter extends PDFStreamEngine {
    protected int documentImageCount = 0;

    public int getDocumentImageCount() {
        return documentImageCount;
    }

    public PdfImageCounter() {
        addOperator(new OperatorProcessor() {
            @Override
            public void process(Operator operator, List<COSBase> arguments) throws IOException {
                if (arguments.size() < 1) {
                    throw new MissingOperandException(operator, arguments);
                }
                if (isImage(arguments.get(0))) {
                    documentImageCount++;
                }
            }

            protected Boolean isImage(COSBase base) {
                return (base instanceof COSName) &&
                        context.getResources().isImageXObject((COSName)base);
            }

            @Override
            public String getName() {
                return "Do";
            }
        });
    }
}