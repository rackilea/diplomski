Bitmap bmp = Bitmap.createBitmap(300, 300, Bitmap.Config.ARGB_8888);
Drawable drawable = getResources().getDrawable(R.drawable.car);
Canvas canvas = new Canvas(bmp);
drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
drawable.draw(canvas);
iv2.setImageBitmap(bmp);