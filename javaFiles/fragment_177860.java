HttpRequest.Builder requestBuilder = HttpRequest.newBuilder()
                .uri(URI.create("http://exampleURL.com/aFile"));

if (myFile.length() > 0) {
    requestBuilder.header("Range","bytes="+myFile.length() +"-"+ totalBytes);
}

requestBuilder.header("xxxx","yyyyy");

HttpRequest request = requestBuilder.build();