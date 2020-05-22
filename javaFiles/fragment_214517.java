public void addTableLink(String s, String s1, int g, LinearLayout L, int fsize, int textColor, int backgroundColor, int lpad, int tpad, final String section, final String selection){

    LinearLayout ll = new LinearLayout(this);

    ll.setOrientation(LinearLayout.HORIZONTAL);
    ll.setGravity(Gravity.CENTER_VERTICAL);

    ll.setLayoutParams(new LinearLayout.LayoutParams(400, 30));

    ll.setBackgroundColor(backgroundColor);

    TextView tv1 = new TextView(this);
    TextView tv2 = new TextView(this);

    tv1.setText(s);
    tv2.setText(s1);

    tv1.setPadding(lpad, tpad, 0, 0);

    tv1.setTextSize(fsize);
    tv2.setTextSize(fsize);

    tv1.setTextColor(textColor);
    tv2.setTextColor(Color.BLUE);
    tv2.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {                  
            setMainView(section, selection);
            setTitle(section);
         }
        });

    ll.addView(tv1);
    ll.addView(tv2);

    L.addView(ll);

}