ImageView imageView = new ImageView(this);
imageView.setImageResource(R.drawable.beerbottle);

RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.RelativeLayout01);
RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(
    RelativeLayout.LayoutParams.WRAP_CONTENT,
    RelativeLayout.LayoutParams.WRAP_CONTENT
);
layoutParams.addRule(RelativeLayout.BELOW, R.id.ButtonRecalculate);
layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

relativeLayout.addView(imageView, layoutParams);