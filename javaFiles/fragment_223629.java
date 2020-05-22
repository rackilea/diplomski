private void populateCategoryGrid() {
    TableLayout categoriesLayout;
    int category_count = 12;
    int NUM_ROW = category_count/3;
    int NUM_COL = category_count/4;
    LayoutInflater inflater = LayoutInflater.from(this);

    // Add rows
    for (int r=0;r<NUM_ROW;r++) {
        TableRow row = new TableRow(this);
        row.setLayoutParams(new TableLayout.LayoutParams(
                TableLayout.LayoutParams.MATCH_PARENT,
                TableLayout.LayoutParams.MATCH_PARENT,
                1.0f
        ));
        // Add inflated layouts
        for (int c = 0; c <NUM_COL; c++) {
            // Inflate layout
            RelativeLayout rl = (RelativeLayout) inflater.inflate(R.layout.rel_layout, null);
            // Modify inflated layout
            ImageView img = (ImageView) rl.findViewById(R.id.img);
            img.setBackgroundColor(Color.RED);
            TextView tv = (TextView) rl.findViewById(R.id.text);
            tv.setText("Some text");
            // Add the modified layout to the row
            row.addView(rl);
        }
        // Add row to the table
        categoriesLayout.addView(row);
    }
}