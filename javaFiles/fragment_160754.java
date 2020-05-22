// builds an URI object from the URI string
java.net.URI uri = java.net.URI.create(getRedirectURI());

// uses the authory(oauth2redirect) as the path to build the uri
UriBuilder uriBuilder = UriBuilder.fromPath(
            // forcefully adds the double slashes (//), without this, 
            // at this point, the uri would be: myapp2:oauth2redirect
            "//" + uri.getAuthority())
            .scheme(uri.getScheme());

uriBuilder.queryParam("code", "myCode");

uriBuilder.build(); // produces the uri: myapp2://oauth2redirect?code=myCode