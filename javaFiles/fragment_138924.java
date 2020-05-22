long count=0;
String row="";

for (Result res : scanner)
{
    for (Cell cell : res.listCells())
    {
        row = new String(CellUtil.cloneRow(cell));
        if(!row.equals(""))
            count++;
    }
}