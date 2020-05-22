@Override
public void onStart() {
    super.onStart();
    IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);
    filter.addAction("tweet_result");
    getActivity().registerReceiver(receiver, filter);


}

private BroadcastReceiver receiver = new BroadcastReceiver() {
    @Override
    public void onReceive(Context context, Intent intent) {
        List<tweet> tweets = (List<tweet>)
     intent.getParcelableArrayList("data");

        if (tweets == null) {
            tweets_results.setText("No tweets");
            return;
        } else {
            for (tweet tweet : tweets) {
                String content = "";
                content += "Created at: " + tweet.getCreated_at() + "\n";
                content += "Text: " + tweet.getText() + "\n";
                content += "Retweets: " + tweet.getRetweet_count() + "\n";
                content += "Favs: " + tweet.getFavorite_count() + "\n\n";
                tweets_results.append(content);
            }
        }
    }
};