TableRow.LayoutParams trParam = new TableRow.LayoutParams();
trParam.column= 6
trParam.span = 5;

TableRow row = new TableRow(this);
TextView content = new TextView(this);
content.setLayoutParams(trParam);
content.addView(title);