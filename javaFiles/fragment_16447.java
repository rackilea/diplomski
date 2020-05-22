float width = 8.5f * 72;
float height = 11f * 72;
float tolerance = 1f;

PdfReader reader = new PdfReader("source.pdf");

for (int i = 1; i <= reader.getNumberOfPages(); i++)
{
    Rectangle cropBox = reader.getCropBox(i);
    float widthToAdd = width - cropBox.getWidth();
    float heightToAdd = height - cropBox.getHeight();
    if (Math.abs(widthToAdd) > tolerance || Math.abs(heightToAdd) > tolerance)
    {
        float[] newBoxValues = new float[] { 
            cropBox.getLeft() - widthToAdd / 2,
            cropBox.getBottom() - heightToAdd / 2,
            cropBox.getRight() + widthToAdd / 2,
            cropBox.getTop() + heightToAdd / 2
        };
        PdfArray newBox = new PdfArray(newBoxValues);

        PdfDictionary pageDict = reader.getPageN(i);
        pageDict.put(PdfName.CROPBOX, newBox);
        pageDict.put(PdfName.MEDIABOX, newBox);
    }
}

PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("target.pdf"));
stamper.close();