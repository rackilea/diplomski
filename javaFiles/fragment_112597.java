targetSheet.addValidationData(dataValidation);

For XSSFWorkbook, use as below

        DataValidationHelper validationHelper=new XSSFDataValidationHelper(targetSheet);
        DataValidationConstraint constraint =validationHelper.createExplicitListConstraint(new String[]{"ABC"});
        DataValidation dataValidation = validationHelper.createValidation(constraint, programList);
        dataValidation.setSuppressDropDownArrow(true);   
        dataValidation.setShowErrorBox(true);
        dataValidation.setShowPromptBox(true);
        targetSheet.addValidationData(dataValidation);