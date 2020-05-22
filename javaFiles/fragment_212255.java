Series<Header> responseHeaders = (Series<Header>) 
response.getAttributes().get(HeaderConstants.ATTRIBUTE_HEADERS); 
if (responseHeaders == null) { 
    responseHeaders = new Series(Header.class); 
    response.getAttributes().put(
            HeaderConstants.ATTRIBUTE_HEADERS, responseHeaders); 
}
responseHeaders.add(new Header("X-MyHeader", "value"));