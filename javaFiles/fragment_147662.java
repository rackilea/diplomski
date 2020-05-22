public GameThreadView(Context context) {
    super(context);  
    gta = (GameThreadAndroid)context;

    holder = getHolder();   

    fg = new Paint(Paint.ANTI_ALIAS_FLAG);
    fg.setTextSize(36);
    fg.setTextAlign(Paint.Align.CENTER);
    fg.setColor(getResources().getColor(R.color.text));

    bg = new Paint();
    bg.setColor(getResources().getColor(R.color.background));
    Log.d("GAME","GameThreadView");

   // Here you set moveY 
   moveY = r.nextFloat() * 0.5f;

   // You need to add somthing similar to moveX, like this
   moveX = r.nextFloat() * 0.5f;


 }