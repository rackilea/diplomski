ImageView image = new ImageView(getApplicationContext());
image.setImageResource(imageArray[position]);
image.setTag(imageNames[position]);
LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(layoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT, 1.0f);
image.setLayoutParams(layoutParams);
linearLayout.addView(image);