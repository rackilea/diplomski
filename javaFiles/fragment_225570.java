@Override
     public Object aroundReadFrom(ReaderInterceptorContext   readerInterceptorContext)
        throws IOException, WebApplicationException {

    InputStream is = readerInterceptorContext.getInputStream();
    String requestBody = new Scanner(is, StandardCharsets.UTF_8.name()).useDelimiter("\\A").next();
    JSONObject request = new JSONObject(requestBody);
    //Adding the stream back to the context object
    readerInterceptorContext.setInputStream(new ByteArrayInputStream(requestBody.getBytes()));
    //Adding properties to read in filter
    readerInterceptorContext.setProperty("ClientId", request.get("ClientId"));
    readerInterceptorContext.setProperty("UserId","UserId"));
    return readerInterceptorContext.proceed();
    }