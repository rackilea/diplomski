setContentView(R.layout.activity_main);
txt = (TextView) findViewById(R.id.result_text);

pb = (ProgressBar) findViewById(R.id.pbar);
pb.setVisibility(View.GONE);
System.out.println(pb.getVisibility());

captions = new HashMap<>();
captions.put(KWS_SEARCH, R.string.kws_caption);
//setContentView(R.layout.activity_main); remove this