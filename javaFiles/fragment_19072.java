@Test
public void processShouldCallItselfWithFailedSublistWhenProcessingFails() {
    Dependency dependency = mock(Dependency.class);
    when(dependency.call()).thenReturn(1, 2).thenThrow(Exception.class).
        thenReturn(4);
    Processor processor = new Processor(dependency);
    processor.processUsers(Arrays.asList(new Integer[]{1, 2, 3}), 0);
    verify(dependency, times(4)).call();
}