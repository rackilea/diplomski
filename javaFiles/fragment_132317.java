Display display = getWindowManager().getDefaultDisplay();
    ImageView iv = (LinearLayout) findViewById(R.id.imageview);
    int width = display.getWidth(); // return image width
    int height = display.getHeight();// return actual height
    //now set custom size
    int actual_size = height - 200;
    LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(width,actual_size );
    iv.setLayoutParams(parms);

//for constraint layout

ConstraintLayout.LayoutParams newParams = new ConstraintLayout.LayoutParams(width,actual_size);
iv.setLayoutParams(newParams );