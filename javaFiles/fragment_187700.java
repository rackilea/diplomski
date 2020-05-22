ArrayList<String> texts = getIntent().getExtras().getStringArrayList("texts");

TextView tv = (TextView) findViewById(R.id.asdf);
TextView dr = (TextView) findViewById(R.id.asdg);

Collections.shuffle(texts);
tv.setText(texts.get(0));
dr.setText(texts.get(1));