@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    final TextView tv;
    tv = new TextView(this);
    tv.setText("sadasdsadssad");
    tv.setVisibility(View.INVISIBLE);

    ViewGroup rl = (ViewGroup) findViewById(R.id.root);


    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT);
    tv.setLayoutParams(lp);

    rl.addView(tv);

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {

            tv.setDrawingCacheEnabled(true);
            tv.buildDrawingCache();

            Bitmap bm = tv.getDrawingCache();

            ImageView im = (ImageView) findViewById(R.id.img_view);

            im.setImageBitmap(bm);
        }
    },100);


}