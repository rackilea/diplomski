class RowData
{
  private String [] cols;

  RowData(String [] theCols)
  {
    cols = theCols;
  }

  String getColumn(int index)
  { 
    return cols[index];
  }
}