ImageView myView = new ImageView(context);
BitmapFactory.Options options = new BitmapFactory.Options();
    options.inSampleSize = 4;

Bitmap bitmap = BitmapFactory.decodeResource(activity.getResouces(), imageArray[position], options );
myView.setImageBitmap(bitmap);

((ViewPager) view).addView(myView);   

return myView;