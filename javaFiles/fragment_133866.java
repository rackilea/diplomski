public static void registerParse(Context context) {
        Parse.setLogLevel(Parse.LOG_LEVEL_VERBOSE);

        Parse.initialize(context, PARSE_APPLICATION_ID, PARSE_CLIENT_KEY);
        ParseInstallation.getCurrentInstallation().saveInBackground();

        ParsePush.subscribeInBackground(PARSE_CHANNEL, new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.d("com.parse.push", "Successfully subscribed to Parse!");
                } else {
                    Log.e("com.parse.push", "failed to subscribe for push", e);
                }
            }
        });
    }

    //This is the user that will be inserted in "Installation class"
    public static void subscribeWithUser(String user) {
        ParseInstallation installation = ParseInstallation.getCurrentInstallation();

        installation.put("user", user);

        installation.saveInBackground(new SaveCallback() {
            @Override
            public void done(ParseException e) {
                if (e == null) {
                    Log.e("subscribeWithUser", "User subscribed successfully!!", e);
                } else {
                    e.printStackTrace();
                    Log.e("subscribeWithUser", "Error to save user", e);
                }
            }
        });


    }