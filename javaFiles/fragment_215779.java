Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);

RelativeLayout layout = (RelativeLayout) findViewById(R.id.layout);
LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
        LinearLayout.LayoutParams.FILL_PARENT, 
        LinearLayout.LayoutParams.WRAP_CONTENT);

imageView = new ImageView(this);
imageView.setLayoutParams(params);
imageView.setImageBitmap(bitmap);

layout.setGravity(Gravity.CENTER_VERTICAL | Gravity.TOP);
layout.addView(imageView);