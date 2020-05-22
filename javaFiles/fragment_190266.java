RestAdapter restAdapter = new RestAdapter.Builder()
            .setEndpoint("http://www.ka-news.de")
            .setConverter(new SimpleXmlConverter())
            .build();

    RssAdapter rssAdapter = restAdapter.create(RssAdapter.class);
    rssAdapter.getItems(new Callback<Feed>() {
        @Override
        public void success(Feed newsitems, Response response) {
            Toast.makeText(getContext(), "oki", Toast.LENGTH_LONG).show();


            List<FeedItem> mItems = new ArrayList<>();

            mItems = newsitems.getmChannel().getFeedItems();
            // Crear un nuevo adaptador
            adapter = new AnimeAdapter(mItems);
            recycler.setAdapter(adapter);

        }

        @Override
        public void failure(RetrofitError error) {
            System.out.println(error);

            Toast.makeText(getContext(), "Error" + error.getMessage(),           Toast.LENGTH_LONG).show();


        }
    });