protected void onCreate(Bundle savedInstanceState) {
     super.onCreate(savedInstanceState);     
     LinearLayout ll = new LinearLayout(this);
     ll.setOrientation(LinearLayout.VERTICAL);  
     DrawView tv = new DrawView(this);
     ll.addView(tv.btnReset, tv.params);
     ll.addView(tv.btnScale, tv.paramsRadio);
     ll.addView(tv);
     setContentView(ll);