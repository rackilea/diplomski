DataType<File> fileType = COL2.getDataType().asConvertedDataType(new StreamingLobBinding());
Field<File> fileCol = DSL.field(COL2.getName(), fileType);
dsl.insertInto(TABLE1)
   .columns(COL1, fileCol)
   .values(VAL1, DSL.val(theFile, fileType))
   .execute();