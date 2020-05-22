Twitter twitter = new TwitterFactory().getInstance();
        User user = twitter.showUser("marissamayer");
        if (user.getStatus() != null) {
            int followers = user.getFollowersCount();
            if (followers>=1000) {
                System.out.println("User "+ user.getScreenName()+" Followers " + user.getFollowersCount());
            }
        } else {
            // the user is protected
            System.out.println("@" + user.getScreenName());
        }