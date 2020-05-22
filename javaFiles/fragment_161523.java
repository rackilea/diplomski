HttpGet httpget = new HttpGet(url);
        HttpContext context = new BasicHttpContext(); 
        HttpResponse response = httpClient.execute(httpget, context); 
        if (response.getStatusLine().getStatusCode() != HttpStatus.SC_OK)
            throw new IOException(response.getStatusLine().toString());
        HttpUriRequest currentReq = (HttpUriRequest) context.getAttribute( 
                ExecutionContext.HTTP_REQUEST);
        HttpHost currentHost = (HttpHost)  context.getAttribute( 
                ExecutionContext.HTTP_TARGET_HOST);
        String currentUrl = (currentReq.getURI().isAbsolute()) ? currentReq.getURI().toString() : (currentHost.toURI() + currentReq.getURI());