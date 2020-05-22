public MyView(Context context) {
            super(context);
            Paint p = new Paint();// Problem is here this is local declaration
            p = new Paint() // do like this and remove above line
            p.setColor(Color.GREEN);
            b = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        }