Result<TblcategoryRecord> result = create
  .insertInto(Tblcategory.TBLCATEGORY) 
  .set(Tblcategory.PARENT_ID, node.getParentid())
  .set(Tblcategory.NAME, node.getName())
  .set(Tblcategory.REM, node.getRem())
  .set(Tblcategory.UIPOS, node.getUipos())
  .returning(Tblcategory.CATEGORY_ID)
  .fetch();