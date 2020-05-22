void removeToUnicodeMaps(PDResources pdResources) throws IOException
{
    COSDictionary resources = pdResources.getCOSObject();

    COSDictionary fonts = asDictionary(resources, COSName.FONT);
    if (fonts != null)
    {
        for (COSBase object : fonts.getValues())
        {
            while (object instanceof COSObject)
                object = ((COSObject)object).getObject();
            if (object instanceof COSDictionary)
            {
                COSDictionary font = (COSDictionary)object;
                font.removeItem(COSName.TO_UNICODE);
            }
        }
    }

    for (COSName name : pdResources.getXObjectNames())
    {
        PDXObject xobject = pdResources.getXObject(name);
        if (xobject instanceof PDFormXObject)
        {
            PDResources xobjectPdResources = ((PDFormXObject)xobject).getResources();
            removeToUnicodeMaps(xobjectPdResources);
        }
    }
}

COSDictionary asDictionary(COSDictionary dictionary, COSName name)
{
    COSBase object = dictionary.getDictionaryObject(name);
    return object instanceof COSDictionary ? (COSDictionary) object : null;
}