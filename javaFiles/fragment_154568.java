Query q = new Query(searchTerm);
        QueryResult result;
        int tempUSerInput = 0; //keep a temp value
        boolean flag = false;

        do {
            result = twitter.search(query);
            List<Status> tweets = result.getTweets(); 

            tempUSerInput = tempUSerInput + tweets.size();

            if(tempUSerInput >= realyourUserInput) // you have already matched the number
                flag = true;                //set the flag 

        } 

        while ((query = result.nextQuery()) != null && !flag);


        // Here Take only realyourUserInput number
        // as you might have taken more than required

        List<Status> finaltweets = new ArrayList();

        for(int i=0; i<realyourUserInput; i++)
            finaltweets.add( tweets.get(i) );   //add them to your final list