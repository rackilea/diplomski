DefaultHttpClient hc = new DefaultHttpClient();

HttpGet httpget = new HttpGet("http://google.com");
HttpContext context = new BasicHttpContext();


hc.setRedirectHandler(new DefaultRedirectHandler() {
    @Override
    public URI getLocationURI(HttpResponse response,
                              HttpContext context) throws ProtocolException {

        //Capture the Location header here
        System.out.println(Arrays.toString(response.getHeaders("Location")));

        return super.getLocationURI(response,context);
    }
});

HttpResponse response = hc.execute(httpget, context);