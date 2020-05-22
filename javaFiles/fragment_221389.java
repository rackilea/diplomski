HttpGet httpget;
try{
    httpget = new HttpGet(url); 

    String auth =new String(Base64.encode(( username + ":" + password).getBytes(),Base64.URL_SAFE|Base64.NO_WRAP));
    httpget.addHeader("Authorization", "Basic " + auth);
    }