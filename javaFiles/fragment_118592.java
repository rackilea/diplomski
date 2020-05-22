final SearchService service = Twitter.getApiClient().getSearchService();

service.tweets(SEARCH_QUERY, null, null, null, SEARCH_RESULT_TYPE, SEARCH_COUNT, null, null,
            maxId, true, new Callback<Search>() {
                @Override
                public void success(Result<Search> searchResult) {
                    Crashlytics.setLong(App.CRASHLYTICS_KEY_SEARCH_COUNT,
                            searchResult.data.searchMetadata.count);
                    setProgressBarIndeterminateVisibility(false);
                    final List<Tweet> tweets = searchResult.data.tweets;
                    adapter.getTweets().addAll(tweets);
                    adapter.notifyDataSetChanged();
                    if (tweets.size() > 0) {
                        maxId = tweets.get(tweets.size() - 1).id - 1;
                    } else {
                        endOfSearchResults = true;
                    }
                    flagLoading = false;
                }

                @Override
                public void failure(TwitterException error) {
                    Crashlytics.logException(error);

                    setProgressBarIndeterminateVisibility(false);
                    Toast.makeText(PoemPopularActivity.this,
                            getResources().getString(R.string.toast_retrieve_tweets_error),
                            Toast.LENGTH_SHORT).show();

                    flagLoading = false;
                }
            }
);