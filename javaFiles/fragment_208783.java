LinearLayout parent = new LinearLayout(context);

parent.setLayoutParams(new GridView.LayoutParams(400, 400));
parent.setOrientation(LinearLayout.VERTICAL);

TextView textView = new TextView(context);
textView.setId(1)
ImageView imageView = new ImageView(mContext);
imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
imageView.setPadding(8, 8, 8, 8);
imageView.setId(0);

parent.addView(imageView);
parent.addView(textView);