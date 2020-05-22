@Test
public void processShouldFailAfterTooManyRetries() {
    Dependency dependency = mock(Dependency.class);
    when(dependency.call()).thenThrow(Exception.class);
    Processor processor = new Processor(dependency);
    final List<Integer> userIds = Arrays.asList(new Integer[]{1, 2, 3});
    final int expectedRetries = 5;
    processor.processUsers(userIds, 0);
    verify(dependency, times(expectedRetries * userIds.size())).call();
}