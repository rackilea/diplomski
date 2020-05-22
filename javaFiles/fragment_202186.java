// creates a map of the keywords with a compiled pattern, which matches the keyword
private Map<String, Pattern> keywordsMap = new HashMap<>();
private TwitterStream twitterStream;
private DatabaseService databaseService; // implement and add this service

public void start(List<String> keywords) {
    stop(); // stop the streaming first, if it is already running

    if(keywords.size() > 0) {
        for(String keyword : keywords) {
            keywordsMap.put(keyword, Pattern.compile(keyword, Pattern.CASE_INSENSITIVE));
        }

        twitterStream = new TwitterStreamFactory().getInstance();
        StatusListener listener = new StatusListener() {
            @Override
            public void onStatus(Status status) {
                insertTweetWithKeywordIntoDatabase(status);
            }
            /* add the unimplemented methods from the interface */
        };
        twitterStream.addListener(listener);
        FilterQuery filterQuery = new FilterQuery();
        filterQuery.track(keywordsMap.keySet().toArray(new String[keywordsMap.keySet().size()]));
        filterQuery.language(new String[]{"en"});

        twitterStream.filter(filterQuery);
    }
    else {
        System.err.println("Could not start querying because there are no keywords.");
    }
}

public void stop() {
    keywordsMap.clear();
    if(twitterStream != null) {
        twitterStream.shutdown();
    }
}

private void insertTweetWithKeywordIntoDatabase(Status status) {
    // search for keywords in tweet text
    List<String> keywords = getKeywordsFromTweet(status.getText());

    if (keywords.isEmpty()) {
        StringBuffer additionalDataFromTweets = new StringBuffer();

        // get extended urls
        if (status.getURLEntities() != null) {
            for (URLEntity url : status.getURLEntities()) {
                if (url != null && url.getExpandedURL() != null) {
                    additionalDataFromTweets.append(url.getExpandedURL());
                }
            }
        }

        // get retweeted status -> text
        if (status.getRetweetedStatus() != null && status.getRetweetedStatus().getText() != null) {
            additionalDataFromTweets.append(status.getRetweetedStatus().getText());
        }
        // get retweeted status -> quoted status -> text
        if (status.getRetweetedStatus() != null && status.getRetweetedStatus().getQuotedStatus() != null
                && status.getRetweetedStatus().getQuotedStatus().getText() != null) {
            additionalDataFromTweets.append(status.getRetweetedStatus().getQuotedStatus().getText());
        }
        // get retweeted status -> quoted status -> extended urls
        if (status.getRetweetedStatus() != null && status.getRetweetedStatus().getQuotedStatus() != null
                && status.getRetweetedStatus().getQuotedStatus().getURLEntities() != null) {
            for (URLEntity url : status.getRetweetedStatus().getQuotedStatus().getURLEntities()) {
                if (url != null && url.getExpandedURL() != null) {
                    additionalDataFromTweets.append(url.getExpandedURL());
                }
            }
        }

        // get quoted status -> text
        if (status.getQuotedStatus() != null && status.getQuotedStatus().getText() != null) {
            additionalDataFromTweets.append(status.getQuotedStatus().getText());
        }
        // get quoted status -> extended urls
        if (status.getQuotedStatus() != null && status.getQuotedStatus().getURLEntities() != null) {
            for (URLEntity url : status.getQuotedStatus().getURLEntities()) {
                if (url != null && url.getExpandedURL() != null) {
                    additionalDataFromTweets.append(url.getExpandedURL());
                }
            }
        }

        String additionalData = additionalDataFromTweets.toString();
        keywords = getKeywordsFromTweet(additionalData);
    }

    if (keywords.isEmpty()) {
        System.err.println("ERROR: No Keyword found for: " + status.toString());

    } else {
        // insert into database
        for(String keyword : keywords) {
            databaseService.insertTweet(status.getText(), status.getCreatedAt(), keyword);
        }
    }

}

// returns a list of keywords which are found in a tweet
private List<String> getKeywordsFromTweet(String tweet) {
    List<String> result = new ArrayList<>();

    for (String keyword : keywordsMap.keySet()) {
        Pattern p = keywordsMap.get(keyword);
        if (p.matcher(tweet).find()) {
            result.add(keyword);
        }
    }

    return result;
}