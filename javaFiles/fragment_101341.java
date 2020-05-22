Example example = service .getXXXPort();

Map<String, Object> req_ctx = ((BindingProvider)example).getRequestContext();
req_ctx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "your web service URL here");

Map<String, List<String>> headers = new HashMap<String, List<String>>();
headers.put("Username", Collections.singletonList("username"));
headers.put("Password", Collections.singletonList("password"));
req_ctx.put(MessageContext.HTTP_REQUEST_HEADERS, headers);