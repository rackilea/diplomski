RadioGroup rg = new RadioGroup(this);
RadioButton[] rb = new RadioButton[storeList.length];
for (int current = 0; current <= (storeList.length - 1); current++) {


    TableRow storeRow = (TableRow)inflater.inflate(R.layout.store_table_row, tl, false);

    TextView tv1 = (TextView)storeRow.findViewById(R.id.tvStoreCount);
    rb[current]  = (RadioButton)storeRow.findViewById(R.id.rb1StoreName);
    rg.addView(rb[current]);
    /*other suff...