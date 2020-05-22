Result<TblcategoryRecord> result = create
  .insertInto(Tblcategory.TBLCATEGORY, 
    Tblcategory.PARENT_ID, Tblcategory.NAME, Tblcategory.REM, Tblcategory.UIPOS)
  .values(node.getParentid(), node.getName(), node.getRem(), node.getUipos())
  .returning(Tblcategory.CATEGORY_ID)
  .fetch();