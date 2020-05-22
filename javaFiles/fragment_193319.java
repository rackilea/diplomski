//for(int i=0;i<(ncols-counter);i++){
while (mainColumnModel.getColumnCount() > 0)
{
    mainColumnModel.removeColumn(mainColumnModel.getColumn(0));
}

//for(int i=0;i<counter;i++){
while (fixedColumnModel.getColumnCount() > 0)
{
    fixedColumnModel.removeColumn(fixedColumnModel.getColumn(0));
}