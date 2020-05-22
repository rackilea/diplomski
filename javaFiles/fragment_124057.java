setContentView(R.id.main);    
 Display display = getWindowManager().getDefaultDisplay();
 ImageView iv = (LinearLayout) findViewById(R.id.left);
 int width = display.getWidth(); // ((display.getWidth()*20)/100) 
 int height = display.getHeight();// ((display.getHeight()*30)/100)
 LinearLayout.LayoutParams parms = new      LinearLayout.LayoutParams(width,height);
 iv.setLayoutParams(parms);