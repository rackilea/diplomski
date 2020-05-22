try {

  // Perform search here...

} catch(HttpStatusException e) {
    switch(e.getStatusCode()) {
        case java.net.HttpURLConnection.HTTP_UNAVAILABLE:
            if (e.getUrl().contains("http://ipv4.google.com/sorry/IndexRedirect?continue=http://google.com/search/...")) {
               // Ask online captcha service for help...
            } else {
               // ...
            }
        break;

        default:
        // ...
    } 
}