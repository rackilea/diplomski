public void planTripBody(String imagename, String nameType,
            String placeId) {

        tableRowCount = tableRowCount + 1;


        // ----------------plan_a_trip_table table
        // body------------------------------------------

        TableRow plan_trip_tr_data = new TableRow(this);

        TableRow.LayoutParams rowParams = new TableRow.LayoutParams(
                LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        rowParams.gravity = Gravity.CENTER;
        plan_trip_tr_data.setLayoutParams(rowParams);

        plan_trip_tr_data.setId(10);
        //plan_trip_tr_data.setBackgroundResource(R.drawable.grey_list_bg);
        plan_trip_tr_data.setLayoutParams(new LayoutParams(
                LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT));

        TableRow.LayoutParams innerParams = new TableRow.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);  

        // select checkbox
        final CheckBox select_checkbox = new CheckBox(this);
        select_checkbox.setId(20);
        select_checkbox.setLayoutParams(innerParams);
        select_checkbox.setTextColor(Color.BLACK);
        select_checkbox.setGravity(Gravity.CENTER);
        select_checkbox.setTextSize(TypedValue.COMPLEX_UNIT_SP, 12);
        plan_trip_tr_data.addView(select_checkbox);

        // image
        final ImageView place_imageview = new ImageView(this);
        place_imageview.setId(20);
        place_imageview.setLayoutParams(innerParams);

        // test_name.setText(parser.getValue(e, KEY_SETNAME));
        //place_imageview.setPadding(5, 5, 5, 5);
        place_imageview.setImageResource(R.drawable.planatrip);
        plan_trip_tr_data.addView(place_imageview);// add the column to
                                                        // the table row
                                                        // here

        // Type
        final TextView name_type = new TextView(this);
        name_type.setLayoutParams(innerParams);

        name_type.setId(21);// define id that must be unique
        // no_of_types.setText(parser.getValue(e, KEY_RIGHTMARKS)); // set
        // the text for the header
        name_type.setText(Html.fromHtml(nameType));
        name_type.setTextColor(Color.BLACK); // set the color
        name_type.setPadding(5, 5, 5, 5); // set the padding (if
                                                // required)
        name_type.setGravity(Gravity.LEFT);
        name_type.setTextSize(18);
        plan_trip_tr_data.addView(name_type); // add the column
                                                            // to
                                                            // the table row
                                                            // here


        // ID
        final TextView place_id = new TextView(this);
        place_id.setLayoutParams(innerParams);

        place_id.setId(21);// define id that must be unique
        // total_amount.setText(parser.getValue(e, KEY_WRONGMARKS)); // set
        // the text for the header
        place_id.setText(placeId);
        place_id.setTextColor(Color.BLACK); // set the color
        place_id.setPadding(5, 5, 5, 5); // set the padding (if
                                                // required)
        place_id.setGravity(Gravity.CENTER);
        place_id.setTextSize(10);
        plan_trip_tr_data.addView(place_id); // add the column
                                                            // to the
        // table row here


        plan_a_trip_table.addView(plan_trip_tr_data,
                new TableLayout.LayoutParams(LayoutParams.FILL_PARENT,
                        LayoutParams.WRAP_CONTENT));

        // ----------------------On click name_type

        name_type.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (!select_checkbox.isChecked()) {
                    select_checkbox.setChecked(true);
                } else {
                    select_checkbox.setChecked(false);
                }

            }
        });
        // ----------------------On click customer_name



    }