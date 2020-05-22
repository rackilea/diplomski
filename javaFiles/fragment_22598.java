public class RssReader {
    private String rssUrl;

    public RssReader(String url) {
        rssUrl = url;
    }

    public Observable<List<RssItem>> getItems() {
        return Observable.create(new Observable.OnSubscribe<List<RssItem>>() {
            @Override
            public void call(Subscriber<? super List<RssItem>> subscriber) {
                try {

                    SAXParserFactory factory = SAXParserFactory.newInstance();
                    SAXParser saxParser = factory.newSAXParser();
                    //Creates a new RssHandler which will do all the parsing.
                    RssHandler handler = new RssHandler();
                    //Pass SaxParser the RssHandler that was created.
                    saxParser.parse(rssUrl, handler);
                    subscriber.onNext(handler.getRssItemList());
                    subscriber.onCompleted();
                } catch (Exception e) {
                    subscriber.onError(e);
                }
            }
        });
    }
}


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    recyclerView = (RecyclerView) findViewById(R.id.rv_test_items);
    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
    recyclerView.setLayoutManager(linearLayoutManager);
    RssReader reader = new RssReader("http://www.feedforall.com/sample.xml");
    reader.getItems()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(new Action1<List<RssItem>>() {
                @Override
                public void call(List<RssItem> items) {
                    final ArrayList<TestItem> testItems = new ArrayList<>(items.size());
                    for (int size = items.size(), i = 0; i < size; i++) {
                        RssItem item = items.get(i);
                        testItems.add(new TestItem(item.getTitle(), item.getDescription()));
                    }
                    recyclerView.setAdapter(new TestItemAdapter(testItems));
                }
            }, new Action1<Throwable>() {
                @Override
                public void call(Throwable e) {
                    e.printStackTrace();
                    Log.e("App", "Failed to download RSS Items");
                }
            });
}