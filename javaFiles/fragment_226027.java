// Custom method to generate gradual color

protected int getColorCode(int position){

    int startColor = Color.parseColor("#F48B5E");
    int endColor = Color.parseColor("#E9A191");

    float fraction = position / (float)getItemCount();
    int color = (Integer) new ArgbEvaluator().evaluate(fraction, startColor, endColor);
    return color;
}