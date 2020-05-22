FL fl = new FL(this);
    ScrollView sv = new ScrollView(this);
    LinearLayout ll = new LinearLayout(this);
    ll.setOrientation(LinearLayout.VERTICAL);
    float[] hsv = {
            0, 1, 0.75f
    };
    float[] h = {
            0, 39, 60, 120, 300
    };
    for (int i = 0; i < 5; i++) {
        TextView tv = new TextView(this);
        hsv[0] = h[i];
        tv.setTextColor(0xffeeeeee);
        tv.setBackgroundColor(Color.HSVToColor(128, hsv));
        tv.setPadding(10, 10, 10, 10);
        tv.setTextSize(64);
        tv.setText("#" + i);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.topMargin = 10;
        params.bottomMargin = 10;
        params.leftMargin = 20;
        params.rightMargin = 20;
        ll.addView(tv, params);
        fl.add(tv);
    }
    sv.addView(ll);
    fl.addView(sv);
    setContentView(fl);