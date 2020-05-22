String[] texts = new String[]{
    getIntent().getExtras().getString("prvi"),
    getIntent().getExtras().getString("drugi"),
    getIntent().getExtras().getString("treci"),
};

TextView tv = (TextView) findViewById(R.id.asdf);
TextView dr = (TextView) findViewById(R.id.asdg);

Random random = new Random();
tv.setText(texts[random.nextInt(3)]);
dr.setText(texts[random.nextInt(3)]);