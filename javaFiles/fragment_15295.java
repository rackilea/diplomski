//setup tracker
        GoogleAnalytics analytics = GoogleAnalytics.getInstance(activity.getApplicationContext());
        //analytics.getLogger().setLogLevel(Logger.LogLevel.VERBOSE);
        Tracker tracker = analytics.newTracker(trackerID);
        tracker.setScreenName(screenName);
        //send information to Google Analytics
        tracker.send(new HitBuilders.AppViewBuilder()
                .setCustomDimension(1, programName)
                .setCustomDimension(2, billingLevel)
                .setCustomDimension(3, repRole)
                .setCustomDimension(4, repID)
                .setCustomDimension(5, repFullName)
                .build());