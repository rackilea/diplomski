// get the text views using dynamic layout IDs
for( int row=0; row<9; row++ )
   for( int col=0; col<9; col++ )
   {
       int layoutID = getResources().getIdentifier("tv"+row+col, "id", getPackageName());
       tv[row][col] = (TextView) findViewById(layoutID);
       // set text for testing
       //tv[row][col].setText(""+row+col);
       // set up to respond to click
       tv[row][col].setOnClickListener( new CellOnClickListener(row, col) );
   }