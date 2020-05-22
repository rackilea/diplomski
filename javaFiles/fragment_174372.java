Facebook facebook = new FacebookFactory().getInstance();
    facebook.setOAuthAppId(Constants.FACEBOOK_APP_ID, Constants.FACEBOOK_APP_SECRET);

    facebook.setOAuthAccessToken(new AccessToken(longToken));
    try {
        String pageToken = null;
        for (Account a : facebook.getAccounts()) {
            if (a.getName().toLowerCase().contains("nameOfPage")) {
                pageToken = a.getAccessToken();
            }
        }