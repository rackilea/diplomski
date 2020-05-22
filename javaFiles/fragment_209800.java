TableLayout yourRootLayout = findView....
int count = yourRootLayout.getChildCount();
for(int i = 0; i < count; i++){
    View v = yourRootLayout.getChildAt(i);
    if(v instanceof TableRow){
        TableRow row = (TableRow)v;
        int rowCount = row.getChildCount();
        for (int r = 0; r < rowCount; r++){
            View v2 = row.getChildAt(r);
            if (v2 instanceof Button){
                Button b = (Button)v2;
                b.setOnClickListener(this);
            }
        }
    }
}