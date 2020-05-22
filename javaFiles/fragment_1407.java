else if (op.getOperation().equals("TJ"))
{
    COSArray previous = (COSArray) tokens.get(o - 1);

    tokens.set(o-1, COSInteger.get(3));
    tokens.set(o, PDFOperator.getOperator("Tr"));
    tokens.add(++o, previous);
    tokens.add(++o, PDFOperator.getOperator("TJ"));
    tokens.add(++o, COSInteger.get(0));
    tokens.add(++o, PDFOperator.getOperator("Tr"));
}