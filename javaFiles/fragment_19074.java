@Test
public void processShouldCallItselfWithFailedSublistWhenProcessingFails() {
    Dependency dependency = mock(Dependency.class);
    when(dependency.call(anyInt())).
        thenReturn(1, 2).thenThrow(Exception.class).thenReturn(4);
    Processor processor = new Processor(dependency);
    processor.processUsers(Arrays.asList(new Integer[]{1, 2, 3}), 0);
    verify(dependency).call(1);
    verify(dependency).call(2);
    verify(dependency, times(2)).call(3);
}

@Test
public void processShouldFailAfterTooManyRetries() {
    Dependency dependency = mock(Dependency.class);
    when(dependency.call(anyInt())).thenThrow(Exception.class);
    Processor processor = new Processor(dependency);
    final List<Integer> userIds = Arrays.asList(new Integer[]{1, 2, 3});
    final int expectedRetries = 5;
    processor.processUsers(userIds, 0);
    for (Integer userId : userIds) {
        verify(dependency, times(expectedRetries)).call(userId);
    }
}