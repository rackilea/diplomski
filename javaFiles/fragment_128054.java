long time_milis = System.currentTimeMillis()/1000L;
String claim_set = "{\n"
     + "  \"iss\":\"something@something.iam.gserviceaccount.com\",\n"
     + "  \"scope\":\"https://www.googleapis.com/auth/devstorage.read_write\",\n"
     + "  \"aud\":\"https://www.googleapis.com/oauth2/v4/token\",\n"
     + "  \"exp\":" + (time_milis + 300) + ",\n"
     + "  \"iat\":" + time_milis + "\n"
     + "}";
bytes = claim_set.getBytes();
claim_set = Base64.getUrlEncoder().encodeToString(bytes);