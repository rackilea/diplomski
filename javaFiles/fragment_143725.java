// Collection to store attributes keys/values
final Map<String, Object> attributes = new ConcurrentHashMap<String, Object>();     

// Mock setAttribute
Mockito.doAnswer(new Answer<Void>() {
    @Override
    public Void answer(InvocationOnMock invocation) throws Throwable {
        String key = invocation.getArgumentAt(0, String.class);
        Object value = invocation.getArgumentAt(1, Object.class);
        attributes.put(key, value);
        System.out.println("put attribute key="+key+", value="+value);
        return null;
    }
}).when(request).setAttribute(Mockito.anyString(), Mockito.anyObject());

// Mock getAttribute
Mockito.doAnswer(new Answer<Object>() {
    @Override
    public Object answer(InvocationOnMock invocation) throws Throwable {
        String key = invocation.getArgumentAt(0, String.class);
        Object value = attributes.get(key);
        System.out.println("get attribute value for key="+key+" : "+value);
        return value;
    }
}).when(request).getAttribute(Mockito.anyString());