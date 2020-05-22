int triangular(int row){
 return row * (row + 1) / 2 + 1;
}

int[] r = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
for(int i=0; i<n_rows; i++){
 for(int j=0; j<=i; j++){
  System.out.print(r[triangular(i)+j]+" ");
 }System.out.println("");
}

row, column
if row>column:
 index=triangular(row)+column