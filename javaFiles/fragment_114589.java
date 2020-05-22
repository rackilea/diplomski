IStockTransfer doc = SBOCOMUtil.newStockTransfer(company);
    doc.setFromWarehouse("RW-QC");
    doc.setComments("Just trasfered let see!!!");
    doc.setDocDate(new Date());
    doc.setDocObjectCode(SBOCOMConstants.BoObjectTypes_oStockTransfer);
    doc.getLines().setItemCode("M100001");
    doc.getLines().setWarehouseCode("RW");
    doc.getLines().setFromWarehouseCode("RW-QC");
    doc.getLines().setQuantity(1.0);
    doc.getLines().getBatchNumbers().setBatchNumber("BTCH0001");
    doc.getLines().getBatchNumbers().setQuantity(1.0);
    doc.getLines().add();
    int ii = doc.add();
    if (ii != 0){
        SBOErrorMessage error = company.getLastError();
        System.out.println(error.getErrorCode());
        System.out.println(error.getErrorMessage());
    } else {
        SBOErrorMessage error = company.getLastError();
        System.out.println(error.getErrorCode());
        System.out.println(error.getErrorMessage());
    }