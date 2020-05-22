//the layout on which you are working
    LinearLayout layout = (LinearLayout) findViewById(R.id.linear_layout_tags);

    //set the properties for button
    Button btnTag = new Button(this);
    btnTag.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
    btnTag.setText("Button");
    btnTag.setId(some_random_id);

    //add button to the layout
    layout.addView(btnTag);