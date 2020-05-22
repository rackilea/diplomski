TableLayout table = (TableLayout) findViewById(R.id.main_table);
TableRow row = new TableRow(this);

TextView item = new TextView(this);
item.setId(200+count); 
item.setText(date);

row.addView(item);
table.addView(row, new TableLayout.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));