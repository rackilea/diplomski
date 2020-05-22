TextView textView = new TextView(this);
textView.setGravity(Gravity.CENTER_VERTICAL);
textView.setText("New TextView");

RelativeLayout layout = (RelativeLayout)findViewByID(R.id.layout_id);
layout.addView(textView);