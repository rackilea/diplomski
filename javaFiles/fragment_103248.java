protected void onCreate(Bundle savedInstanceState) { 
super.onCreate(savedInstanceState);
setContentView(R.layout.main);
TableLayout myTable = (TableLayout) findViewById(R.id.myTable);
for (int x = 0; x < 5; x++) {
TextView tv = new TextView(this);
tv.setText("This is row number=" + (x + 1));
TableRow tr = new TableRow(this);
tr.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT,
LayoutParams.WRAP_CONTENT));
tr.addView(tv);
myTable.addView(tr, LayoutParams.FILL_PARENT,
LayoutParams.WRAP_CONTENT);
}
}