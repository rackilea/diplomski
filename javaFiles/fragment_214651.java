public static String getAuthURL(String authCode) {
            return "https://graph.facebook.com/oauth/access_token?"+
                    "client_id=" + client_id +
                    "&redirect_uri=" + redirect_uri + 
                    "&client_secret=" + secret + 
                    "&code=" + authCode;
        }