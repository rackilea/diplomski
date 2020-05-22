for(int i = 0; i < MatrixMultiply.h1; i++){
       columnEditTexts = new ArrayList<EditText>();
       TableLayout table = (TableLayout)findViewById(R.id.myTableLayout);
       TableRow row = new TableRow(this);
       EditText column = new EditText(this);
       for(int j = 0; j < MatrixMultiply.w1; j++) {               
           column = new EditText(this);
           column.setId(i);
           row.addView(column);
           columnEditTexts.add(column);
       }
       table.addView(row);
       arrayOfEditTexts.add(columnEditTexts);
   }