private class ExampleTransferHandler extends TransferHandler{
  public boolean canImport(TransferSupport support){
    if(onlyColumnInsert){
        return ((JTable.DropLocation)support.getDropLocation()).isInsertColumn();
    }else{
        return true;
    }
  }
}