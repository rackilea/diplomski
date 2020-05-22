Mockito.when(instance.method(Mockito.anyInt(), Mockito.anyInt()))
    .thenAnswer(
        new Answer<Integer>() {
          @Override public Integer answer(InvocationOnMock invocation) {
            int a = (Integer) invocation.getArguments()[0];
            int b = (Integer) invocation.getArguments()[1];
            if (a - b == 20) {
              return ...;
            } else {
              return ...;
            }
          }
        });