public static List<ExtendedDataValidations> getExtendedDataValidations(Sheet sheet)
{
    List<ExtendedDataValidations> extendedDataValidationsList = new ArrayList<>();

    if (sheet instanceof XSSFSheet)
    {
        CTExtensionList extLst = ((XSSFSheet) sheet).getCTWorksheet().getExtLst();
        if (extLst == null)
        {
            return extendedDataValidationsList;
        }

        CTExtension[] extArray = extLst.getExtArray();
        List<Node> dataValidationNodes = new ArrayList<>();
        for (CTExtension anExtArray : extArray)
        {
            searchForDataValidation(anExtArray.getDomNode(), dataValidationNodes);
        }

        for (Node dataValidationNode : dataValidationNodes)
        {
            ExtendedDataValidations dataValidations = new ExtendedDataValidations();
            getDataValidationInfo(dataValidationNode, dataValidations);
            extendedDataValidationsList.add(dataValidations);
        }

    }

    return extendedDataValidationsList;
}