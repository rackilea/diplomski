FrameLayout btn = new FrameLayout(this);
btn.setPadding(0, 0, 0, 0);
btn.setLayoutParams(new TableRow.LayoutParams(
    ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT
));

TextView text = new TextView(this);
text.setText("Button: " + i + j);

btn.addView(text);
btn.setBackgroundResource(R.drawable.down_button_lesser_opacity_selector);
btn.setClickable(true);