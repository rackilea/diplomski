// define the headers you want to be returned
Map<String, String> headers = new HashMap<>();
headers.put(null, "HTTP/1.1 200 OK");
headers.put("Content-Type", "text/html");

// create an Enumeration over the header keys
Iterator<String> iterator = headers.keySet().iterator();
Enumeration headerNames = new Enumeration<String>() {
    @Override
    public boolean hasMoreElements() {
        return iterator.hasNext();
    }

    @Override
    public String nextElement() {
        return iterator.next();
    }
};

// mock HttpServletRequest
HttpServletRequest request = mock(HttpServletRequest.class);
// mock the returned value of request.getHeaderNames()
when(request.getHeaderNames()).thenReturn(headerNames);

System.out.println("demonstrate output of request.getHeaderNames()");
while (headerNames.hasMoreElements()) {
    System.out.println("header name: " + headerNames.nextElement());
}

// mock the returned value of request.getHeader(String name)
doAnswer(new Answer<String>() {
    @Override
    public String answer(InvocationOnMock invocation) throws Throwable {
        Object[] args = invocation.getArguments();
        return headers.get((String) args[0]);
    }
}).when(request).getHeader("Content-Type");

System.out.println("demonstrate output of request.getHeader(String name)");
String headerName = "Content-Type";
System.out.printf("header name: [%s]   value: [%s]%n", 
        headerName, request.getHeader(headerName));
}