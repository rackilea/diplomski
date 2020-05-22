TableLayout flightInfoTable = (TableLayout) findViewById(R.id.flightInfoTable);
flightInfoTable.setStretchAllColumns(true);
flightInfoTable.setShrinkAllColumns(true);

for (int i = 16; i < flightInfoArrayLenght - 1; i++) {

TableRow rowFlightInfo = new TableRow(this);
    rowFlightInfo.setGravity(Gravity.CENTER);
    rowFlightInfo.setPadding(5, 10, 5, 10);
    TableRow.LayoutParams params = new TableRow.LayoutParams();
    params.width = -2;
    rowFlightInfo.setLongClickable(true);
    //registerForContextMenu(rowFlightInfo);

TextView tvTerminal = new TextView(this);
    tvTerminal.setGravity(Gravity.CENTER);
    tvTerminal.setText(flightInfoArray[i][6]);
    rowFlightInfo.addView(tvTerminal, params);

etc.. etc..

flightInfoTable.addView(rowFlightInfo);

rowFlightInfo.setOnLongClickListener(new OnLongClickListener() {

                 @Override
                        public boolean onLongClick(View v) {
                          String flightNumber = tvFlight.getText().toString();
                          flightNumber = flightNumber.replaceAll("\\s", "");
                          setIntent(getIntent().putExtra("flightNumber", flightNumber));
                          setIntent(getIntent().putExtra("flightInfo", "From " + tvFrom.getText() + " to Colombo"));
                          registerForContextMenu(v);
                          openContextMenu(v);
                          unregisterForContextMenu(v);
                          return true;
                        }
                      });

}