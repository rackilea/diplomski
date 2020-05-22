public void callingFunction() {
    TableLayout tl1 = // something;
    TableLayout tl2 = // something else;

    addHeaders(tl1, "Address", "Type", "Amount", "Date");
    addHeaders(tl2, "new", "strings", "for", "table");
}

public TableRow addHeaders(TableLayout tl, String ... names) {
 if (names.length != 4) throw new Exception("Unexpected number of table header names");

/* Create a TableRow dynamically */
TableRow tr = new TableRow(this);
tr.setBackgroundColor(GRAY);
tr.setLayoutParams(new TableLayout.LayoutParams(
        TableLayout.LayoutParams.MATCH_PARENT,
        TableLayout.LayoutParams.WRAP_CONTENT));


/* Creating a TextView to add to the row */
TextView addressTV = new TextView(this);
addressTV.setText(names[0]);
addressTV.setTextColor(Color.BLACK);
addressTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
addressTV.setGravity(Gravity.CENTER_HORIZONTAL);
addressTV.setPadding(0, 7, 0, 7);
addressTV.setLayoutParams(new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.7f));
tr.addView(addressTV);  // Adding textView to tablerow.

/* Creating a TextView to add to the row */
TextView typeTV = new TextView(this);
typeTV.setText(names[1]);
typeTV.setTextColor(Color.BLACK);
typeTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
typeTV.setGravity(Gravity.CENTER_HORIZONTAL);
typeTV.setPadding(0, 7, 0, 7);
typeTV.setLayoutParams(new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1f));
tr.addView(typeTV);  // Adding textView to tablerow.

/* Creating another textview */
TextView amountTV = new TextView(this);
amountTV.setText(names[2]);
amountTV.setTextColor(Color.BLACK);
amountTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
amountTV.setGravity(Gravity.CENTER_HORIZONTAL);
amountTV.setPadding(0, 7, 0, 7);
amountTV.setLayoutParams(new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.2f));
tr.addView(amountTV); // Adding textView to tablerow.

/* Creating another textview */
TextView dateTV = new TextView(this);
dateTV.setText(names[3]);
dateTV.setTextColor(Color.BLACK);
dateTV.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
dateTV.setGravity(Gravity.CENTER_HORIZONTAL);
dateTV.setPadding(0, 7, 0, 7);
dateTV.setLayoutParams(new TableRow.LayoutParams(0, LayoutParams.WRAP_CONTENT, 1.5f));
tr.addView(dateTV); // Adding textView to tablerow.

// Add the TableRow to the TableLayout
tl.addView(tr, new TableLayout.LayoutParams(
        LayoutParams.MATCH_PARENT,
        LayoutParams.WRAP_CONTENT));
}