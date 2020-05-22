private class FeedListAdapter extends ArrayAdapter<Object> {

    public FeedListAdapter() {
        super(Feeds.this, R.layout.feed, new Object[feedArrLength]);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View feed = convertView;
        FeedWrapper wrapper = null;

        if (feed == null) {

            feed = getLayoutInflater().inflate(R.layout.feed, parent, false);
            wrapper = new FeedWrapper(feed);
            feed.setTag(wrapper);
        }
        else {
            wrapper = (FeedWrapper)feed.getTag();
        }

        wrapper.getName().setText(arr.get(position).getName());
        wrapper.getProfilePicture().setImageBitmap(arr.get(position).getProfilePicture());
        View feedContentView = createContentView(arr.get(position).getContent());
        wrapper.getContent().addView(feedContentView);
        return(feed);
    }

    private View createContentView(FeedContent feedContent) {
        ... // Here you shuold inflate new view and fill it with data from "feedContent"
    }
}