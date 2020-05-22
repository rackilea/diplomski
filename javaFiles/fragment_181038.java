private void changeColor(TextView textView)
{
Drawable tempDrawable = getResources().getDrawable(R.drawable.choose_plan_bg);
LayerDrawable bubble = (LayerDrawable) tempDrawable; //(cast to root element in xml)
GradientDrawable solidColor = (GradientDrawable) bubble.findDrawableByLayerId(R.id.outerRectangle);
solidColor.setColor(getResources().getColor(R.color.green));
textView.setBackground(tempDrawable);
textView.setTextColor(getResources().getColor(R.color.white));


}