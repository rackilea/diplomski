//The filter is false
    testObject.set(null);
    String filterFalse = Mono.just(test)
            .doOnNext(string -> {
              if (string.equals("Something Else"))
                  testObject.set(string);
             })   
            .block();
    Assert.assertEquals(null, testObject.get());
    Assert.assertEquals(test, filterFalse);