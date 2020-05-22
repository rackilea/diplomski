UriBuilder builder = new UriBuilder()
    .setScheme("https")
    .setHost("www.google.com")
    .setPath("/p1/p2")
    .addParameter("what",null)
    .addParameter("k1", "v1")
    .addParameter("k2", "v2")
builder.toString();