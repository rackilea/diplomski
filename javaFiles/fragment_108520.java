for(row=0;row<4;row++){
   for(column=0;column<9;column++) {
      if(row<2) {
         isi[row][column]= String.valueOf(c[0][column][row]);
         premise.setValueAt(isi[row][column], row, column);
      }
      else {
         int row2 = row - 2;
         isi[row2][column] = String.valueOf(a[0][column][row2]);
         premise.setValueAt(isi[row2][column], row2, column);
      }
   }     
}