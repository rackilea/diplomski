LinearLayout newLL = new LinearLayout(mContext);
newLL.setLayoutParams(newLinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
newLL.setOrientation(LinearLayout.HORIZONTAL);
newLL.setGravity(Gravity.LEFT);
newLL.addView(btn);
widthSoFar = btn.getMeasuredWidth();