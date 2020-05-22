LinearLayout  mainLinear = (LinearLayout) findViewById(R.id.container);

        for (int i = 0; i < 5; i++) {
            tableRow = new TableRow(getApplicationContext());
            for (int j = 0; j < 4; j++) {
                textView = new TextView(getApplicationContext());
                textView.setText("Hello");
                textView.setPadding(20, 20, 20, 20);
                tableRow.addView(textView);
            }
            tableLayout.addView(tableRow);
        }
        mainLinear.addView(tableLayout);