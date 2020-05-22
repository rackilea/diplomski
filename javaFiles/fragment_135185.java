for (int i = 0; i < row.getLastCellNum(); i++)
{
    cell = row.getCell(i);
    if (cell == null)
    {
        System.out.println("null");
    }
    else
    {
        System.out.println(cell.getStringCellValue());
    }
}