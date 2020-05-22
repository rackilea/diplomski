@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    LinearLayout mainContainer = (LinearLayout)findViewById(R.id.main_container);

    int cols = 5;
    int rows = 5;


    //Params used for cells
    TableRow.LayoutParams params = new TableRow.LayoutParams(
            0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f
    );
    int pixelsToDp = convertToPixelsDp(-4.5f);
    params.setMargins(pixelsToDp, pixelsToDp, pixelsToDp, pixelsToDp);

    //Params used for rows
    TableRow.LayoutParams rowParams = new TableRow.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
    );
    rowParams.setMargins(0, 0, 0, 0);

    //Params used for table
    TableLayout.LayoutParams tableParams = new TableLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT
    );
    tableParams.setMargins(0, 0, 0, 0);

    //Table generation
    TableLayout table = new TableLayout(this);
    table.setLayoutParams(tableParams);
    table.setShowDividers(TableLayout.SHOW_DIVIDER_NONE);
    table.setStretchAllColumns(true);

    for(int i = 0; i < rows; i++){

        TableRow row = new TableRow(this);

        row.setShowDividers(TableRow.SHOW_DIVIDER_NONE);
        row.setLayoutParams(rowParams);

        for(int j = 0; j < cols; j++){

            ImageButton btn = new ImageButton(this);

            btn.setPadding(0, 0, 0, 0);
            btn.setLayoutParams(params);
            btn.setScaleType(ImageView.ScaleType.CENTER_CROP);

            //The button's background has the unneeded margin
            //so if you set correct background drawable I think
            //you might achieve what you want API lvl 16 above
            //btn.setBackground(null);

            //API Level 17 and above
            //If you want id's for some reason you could store them in
            //some kind of Dictionary or you could store the UI elements
            //to have access to them

            //int id = btn.generateViewId();
            //btn.setId(id);

            row.addView(btn);
        }

        table.addView(row);
    }

    mainContainer.addView(table);

}

public int convertToPixelsDp(float pixels){
    int px = (int)TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            pixels,
            this.getResources().getDisplayMetrics());
    return px;
}