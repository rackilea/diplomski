String a="A";
    for (int i = 0; i < xssfSheet.getPhysicalNumberOfRows(); i++)
{
  CellReference cellReference = new CellReference(a+i);
    Row row = xssfSheet.getRow(cellReference.getRow());

        //your Logic
}