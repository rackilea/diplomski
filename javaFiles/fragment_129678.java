LinearLayout layout = new LinearLayout(this);
layout.setGravity(Gravity.CENTER|Gravity.TOP);
layout.setOrientation(LinearLayout.VERTICAL);
test = new TextView(this);
LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
test.append("test");
activityTitle.setGravity(Gravity.CENTER);
layout.addView(activityTitle, params);
setContentView(layout);