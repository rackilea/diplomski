RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)btBroadcast.getLayoutParams();
params.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
params.addRule(RelativeLayout.CENTER_VERTICAL);
params.height = 10;
params.width = 20;
params.rightMargin = 10;
btBroadcast.setScaleType(ImageView.ScaleType.CENTER);
btBroadcast.setBackgroundResource(R.drawable.image);
btBroadcast.requestLayout();