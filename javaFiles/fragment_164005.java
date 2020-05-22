ConfigurationBuilder cb = new ConfigurationBuilder();
           cb.setDebugEnabled(true)
               .setOAuthConsumerKey(consumerKey)
               .setOAuthConsumerSecret(consumerSecret)
               .setOAuthAccessToken(accessToken)
               .setOAuthAccessTokenSecret(accessSecret);
         try 
         {
              TwitterFactory factory = new TwitterFactory(cb.build());
              Twitter twitter = factory.getInstance();
              String[] srch = new String[] {"usernameoffriend"};
              ResponseList<User> users = twitter.lookupUsers(srch);
              for (User user : users) {
                System.out.println("Friend's Name " + user.getName()); // this print my friends name
                    if (user.getStatus() != null) 
                    {
                    System.out.println("Friend timeline");
                    List<Status> statusess = twitter.getUserTimeline(user.getName());
                    for (Status status3 : statusess) 
                     {
                            System.out.println(status3.getText());
                     }
        }
    }