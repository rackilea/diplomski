private Context context;

    public FeedListAdapter(Context context,Activity activity, List<FeedItem> feedItems) {
        this.context = context;
        this.activity = activity;
        this.feedItems = feedItems;
    }