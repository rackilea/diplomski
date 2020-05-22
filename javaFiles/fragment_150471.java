@NonNull
 private Bundle mockBundle() {
       final Map<String, String> fakeBundle = new HashMap<>();
       Bundle bundle = mock(Bundle.class);
       doAnswer(new Answer() {
       @Override
       public Object answer(InvocationOnMock invocation) throws Throwable {
             Object[] arguments = invocation.getArguments();
             String key = ((String) arguments[0]);
             String value = ((String) arguments[1]);
             fakeBundle.put(key, value);
             return null;
       }
       }).when(bundle).putString(anyString(), anyString());
       when(bundle.get(anyString())).thenAnswer(new Answer<String>() {
              @Override
              public String answer(InvocationOnMock invocation) throws Throwable {
                   Object[] arguments = invocation.getArguments();
                   String key = ((String) arguments[0]);
                   return fakeBundle.get(key);
               }
       });
       return bundle;
  }