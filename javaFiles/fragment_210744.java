try {
            ResponseList<Status> a = twitter.getHomeTimeline(new Paging(1,1000));

            for (Status b: a){
                long userId = b.getUser().getId();// user Id
                String userName = b.getUser().getName(); // user name
                String tweetText = b.getText(); // tweet

                System.out.println(userId+" "+userName+" "+tweetText);
            }
        }