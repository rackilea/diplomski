QueryResult result = twitter.search(new Query("Some term"));
        for (Status status : result.getTweets())
        {
            System.out.println(status.getText());
            System.out.println(status.getFavoriteCount());
            System.out.println(status.isFavorited());
        }