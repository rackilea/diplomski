//org.apache.pdfbox.preflight.process.reflect.SinglePageValidationProcess#validateGroupTransparency
    protected void validateGroupTransparency(PreflightContext context, PDPage page) throws ValidationException
    {
        COSBase baseGroup = page.getCOSObject().getItem(XOBJECT_DICTIONARY_KEY_GROUP);
        COSDictionary groupDictionary = COSUtils.getAsDictionary(baseGroup, context.getDocument().getDocument());
        if (groupDictionary != null)
        {
            String sVal = groupDictionary.getNameAsString(COSName.S);
            if (XOBJECT_DICTIONARY_VALUE_S_TRANSPARENCY.equals(sVal))
            {
                context.addValidationError(new ValidationError(ERROR_GRAPHIC_TRANSPARENCY_GROUP,
                        "Group has a transparency S entry or the S entry is null"));
            }
        }
    }