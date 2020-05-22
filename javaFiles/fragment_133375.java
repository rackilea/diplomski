Ok got it I forgot to get new OnClickListener this fixed the formatting issue writing this line of code OnClickListener resetListener = new OnClickListener() {


OnClickListener resetListener = new OnClickListener() { 
        public void onClick(View v) {
            Intent intent = getIntent();
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            finish();

            overridePendingTransition(0, 0);
            startActivity(intent);
            setContentView(R.layout.activity_main);
    } 
};