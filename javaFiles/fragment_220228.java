{
       CellRangeAddressList addressList = 
       new CellRangeAddressList(1,10,columnIndexFromHeaderList,columnIndexFromHeaderList);
       DVConstraint dvConstraint = 
       DVConstraint.createExplicitListConstraint(stringArray);
       dataValidation = new HSSFDataValidation(addressList,dvConstraint);                      
       dataValidation.setSuppressDropDownArrow(false);
       sheet.addValidationData(dataValidation );

    }