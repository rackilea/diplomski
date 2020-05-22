final Object item = getIntent().getExtras().get("item");
  String getClass = getIntent().getStringExtra("class");

    if (getClass.equals("Illusion")) {
        Illusion illusion = (Illusion) item;

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText(illusion.getName());

        //some more resource settings here

    } else if (getClass.equals("FavouriteIllusion") {
        FavouriteIllusion illusion = (FavouriteIllusion) item;

        TextView title = (TextView) findViewById(R.id.tv_title);
        title.setText(illusion.getName());

        //some more resource settings here

    }