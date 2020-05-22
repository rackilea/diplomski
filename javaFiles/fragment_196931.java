Button btnClear = (Button) findViewById (R.id.btnClearAll);
btnClear.setOnClickListener (new OnClickListener () {

    @Override
    public void onClick (View v) {
        for (int i = 0 ; i < color.length; i++) {
            final GradientDrawable ivCircleOnClick = (GradientDrawable) color[i].getBackground ();
            ivCircleOnClick.setStroke (0, Color.WHITE);
            color[i].setTag ("0");
            ctr = 0;
            message = "";
        }
    }
});