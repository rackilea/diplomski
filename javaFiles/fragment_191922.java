nameTv = (TextView) findViewById(R.id.name_tv);
    mobileTv = (TextView) findViewById(R.id.mobile_tv);

    String name,mobile_number;
    //get Intent data
    name=getIntent().getStringExtra("name");
    mobile_number=getIntent().getStringExtra("mobile");
    nameTv.setText(name);
    mobileTv.setText(mobile_number);