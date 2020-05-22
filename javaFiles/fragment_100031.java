BindingProvider bindingProvider = (BindingProvider) Port;
     Map<String,Object> requestContext = bindingProvider.getRequestContext();
     Map<String, List<String>> requestHeaders = new HashMap<String, List<String>>();
     List<String> cookies = new ArrayList<String>();
     cookies.add("SMSESSION=testCookie");
     requestHeaders.put("Cookie", cookies);
     requestContext.put(MessageContext.HTTP_REQUEST_HEADERS, requestHeaders);