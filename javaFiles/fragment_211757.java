for (int i=0; i<num_rows; i++) {

        TableRow tbl_row= new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        tbl_row.setLayoutParams(lp);
        tbl_row.setPadding(0, 5, 0, 5);
        //tbl_row.setBackground(R.drawable.border);

       if(i == 3)
            tbl_row.setBackgroundColor(Color.GREEN);
        else
            tbl_row.setBackgroundColor(Color.parseColor("#ffffd1"));

        tbl_row.setGravity(Gravity.CENTER);


        TextView tv = new TextView(this);
        tv.setGravity(Gravity.CENTER);
        tv.setText("Some text goes here\New line.");


        ImageButton infoBtn = new ImageButton(this);
        infoBtn.setImageResource(R.drawable.ic_menu_info);
        infoBtn.setAdjustViewBounds(true);
        infoBtn.setScaleType(ImageView.ScaleType.FIT_XY);
        infoBtn.setMaxHeight(120);
        infoBtn.setMaxWidth(120);
        //infoBtn.setId(i);
        //infoBtn.setBackgroundColor(Color.BLUE);
       infoBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
            }
        });

        ImageButton cameraBtn = new ImageButton(this);
        cameraBtn.setImageResource(R.drawable.ic_menu_camera);
        cameraBtn.setAdjustViewBounds(true);
        cameraBtn.setScaleType(ImageView.ScaleType.FIT_XY);
        cameraBtn.setMaxHeight(120);
        cameraBtn.setMaxWidth(120);
        //cameraBtn.setId(i);
        cameraBtn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
            }
        });

        tbl_row.addView(infoBtn);
        tbl_row.addView(tv);
        tbl_row.addView(cameraBtn);
        tbl_layout.addView(tbl_row, i);
    }`