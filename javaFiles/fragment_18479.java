ResponseList<Status> result = twitter.getFavorites();
        for (Status status : result)
        {
            System.out.println(status.getText());
            System.out.println(status.isFavorited());
        }