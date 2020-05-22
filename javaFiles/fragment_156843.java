Twitter twitter = new TwitterFactory().getInstance();
        int page = 1;
        ResponseList<User> users;
        do {
            users = twitter.searchUsers("search_keyword", page);
            for (User user : users) {
                if (user.getStatus() != null && user.getFollowersCount()>=1000) {
                    System.out.println("@" + user.getScreenName()+" Followers: "+user.getFollowersCount());
                } else {
                    // the user is protected
                    System.out.println("@" + user.getScreenName());
                }
            }
            page++;
        } while (users.size() != 0 && page < 50);