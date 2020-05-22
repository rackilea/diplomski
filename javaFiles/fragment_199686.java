sp = getPreferences(MODE_PRIVATE);
    access_token = sp.getString("access_token", null);
    expires = sp.getLong("access_expires", 0);
    getName = sp.getString("name", null);

    if (access_token != null){
        facebook.setAccessToken(access_token);
        fbName.setText("Hello, " + getName);
        updateButtonStatus();
    }
    if (expires != 0){
        facebook.setAccessExpires(expires);

    }