private void initializeGameView(){    
    RelativeLayout rl = (RelativeLayout) findViewById(R.id.rl_dummy_xml);

    LinearLayout ll = new LinearLayout(this);

    //Layout stuff
    ll.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
    ll.setOrientation(LinearLayout.VERTICAL);
    ll.setGravity(Gravity.CENTER_HORIZONTAL);

    //add more stuff, play around with whatever you want to do here
    gv = new GameView();
    ll.addView(gv);

    tv = new TextView(this);
    tv.setText(gv.getScore());
    ll.addView(tv);

    //Finally, don't forget to add the linear layout to the relative layout
    rl.addView(ll);
}