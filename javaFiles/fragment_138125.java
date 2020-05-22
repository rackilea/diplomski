void pushUnder(PDDocument document)
{
    List<?> pages = document.getDocumentCatalog().getAllPages();
    float fontSize = 70.0f;
    for (int i = 0; i < pages.size(); i++) {
        PDPage page = (PDPage) pages.get(i);
        COSBase contents = page.getCOSDictionary().getDictionaryObject(COSName.CONTENTS);
        if (contents instanceof COSStreamArray)
        {
            COSStreamArray contentsArray = (COSStreamArray) contents;
            COSArray newArray = new COSArray();
            newArray.add(contentsArray.get(0));
            newArray.add(contentsArray.get(contentsArray.getStreamCount() - 1));

            for (int j = 1; j < contentsArray.getStreamCount() - 1; j++)
            {
                newArray.add(contentsArray.get(j));
            }

            COSStreamArray newStreamArray = new COSStreamArray(newArray);
            page.getCOSDictionary().setItem(COSName.CONTENTS, newStreamArray);
        }
    }
}