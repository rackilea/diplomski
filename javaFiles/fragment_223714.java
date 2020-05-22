PDDocument doc = PDDocument.load("C:/mydoc3.pdf");
for (int i = 0; i < doc.getNumberOfPages(); ++i)
{
    PDPage page = doc.getPage(i);
    PDResources res = page.getResources();
    for (COSName fontName : res.getFontNames())
    {
        PDFont font = res.getFont(fontName);
        // do stuff with the font
    }
}