@Mock
private Function<String, Integer> callable;

AtomicInteger count= new AtomicInteger(); //here is the actual invocation count stored

countInvocations(callable,count).apply( anyString());

assertThat(count.get(),is(2));