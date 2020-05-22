mAuth = FirebaseAuth.getInstance();

            if (mAuth.getCurrentUser() != null) {
                // already signed in

                twitter_consumer_key= preferences.getString("TWITTER_CONSUMER_KEY","");
                twitter_consumer_secret= preferences.getString("TWITTER_CONSUMER_SECRET","");

                TwitterAuthConfig authConfig =  new TwitterAuthConfig(twitter_consumer_key, twitter_consumer_secret);
         //setting up fabric       
         Fabric.with(this, new TwitterCore(authConfig), new TweetComposer());


            }

and then let's say I want to tweet from a custom button onClick:

        ImageButton tweetButton= (ImageButton) findViewById(R.id.tweet_button);

tweetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TweetComposer.Builder builder = new TweetComposer.Builder(mContext)
                        .text("just setting up my Fabric.");
                builder.show();

            }
        });