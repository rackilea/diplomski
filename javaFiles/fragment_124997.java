for(int i=0; i<ROW_COUNT; i++) {
    for(int j=0; j<COL_COUNT; j++) {
        String a = ROWS[i];
        String b = COLS[j];
        int editTextId = getResources().getIdentifier("box" + a + b , "id", getPackageName());
        EditText et=(EditText)findViewById(editTextId);    
        et.setText("");
    }
}