// This will give you the names of the columns returned.
int colCount = cur.getColumnCount(); // get number of columns returned

for (int i =0; i < colCount ; i++ ){ 
    Log.d("debuginfo","column: "+cur.getColumnName(i) ); 
}