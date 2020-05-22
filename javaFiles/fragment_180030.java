Cell[][] cells = new Cell[12][12];
for(int x=0; x<12; x++) {
   for(int y=0; y<12; y++) {
       Cell cell = new Cell();
       cell.setName( "" + ('A' + x) + ('A' + y)); // perhaps
       cells[x][y] = cell;
   }
}