windowManager2 = (WindowManager)getSystemService(WINDOW_SERVICE);
 LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE); 
View view=layoutInflater.inflate(R.layout.popupmenu, null); 
params=new WindowManager.LayoutParams( WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.TYPE_PHONE, WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE, PixelFormat.TRANSLUCENT);
 params.gravity=Gravity.CENTER|Gravity.CENTER;
 params.x=0; 
params.y=0; 
windowManager2.addView(view, params);