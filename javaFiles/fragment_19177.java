Context context = this;
    Button btn1 = (Button) findViewById(R.id.btn1);
    Button btn2 = (Button) findViewById(R.id.btn2);
    Button btn9 = (Button) findViewById(R.id.btn9);

    btn1.setOnClickListener(mClick);
    btn2.setOnClickListener(mClick);
    btn9.setOnClickListener(mClick);


View.OnClickListener mClick = new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn1: {
                Intent i1 = new Intent(context, First.class);
                startActivity(i1);
                break;
            }
            case R.id.btm2: {
                Intent i2 = new Intent(context, Second.class);
                startActivity(i2);
                break;
            }
            //create this for all 9 buttons
        }

    }
};