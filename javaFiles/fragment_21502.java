LinearLayout rootLayout = (LinearLayout) findViewById(R.id.nonogram);

for(int row = 0; row < field.getRowCount(); row ++) {
    [...]
    rootLayout.addView(row1);
}