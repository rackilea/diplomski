for (int i = 0 ; i < color.length ; i++) {
    color[i] = (ImageView) findViewById (ivCirclesId[i]);
    final GradientDrawable ivCircleOnClick = (GradientDrawable) color[i].getBackground ();
    color[i].setTag ("0");
    color[i].setOnClickListener (new OnClickListener() {

        public void onClick (View v) {
            if (v.getTag ().toString ().equals ("1")) {
                --ctr;
                v.setTag ("0");
                ivCircleOnClick.setStroke (0, Color.WHITE);
            } else {
                if(ctr >= 8) {
                    Toast.makeText (getApplicationContext (), "Limit reached!", Toast.LENGTH_SHORT).show ();
                    return;
                }
                ++ctr;
                v.setTag ("1");
                ivCircleOnClick.setStroke (4, Color.WHITE);
                //message = message + "#" + v.getContentDescription ();
                return;
            }
        }
    });