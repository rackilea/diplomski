final ObservableEmitter<String> destination = ...

DirScan dirscan = Mockito.spy(createDirScan(source, destination));

Mockito.when(dirscan.getResult(Mockito.any(String.class))).thenAnswer((Answer<Action>) invocation -> {
    String result = invocation.getArgument(0);
    destination.onNext(result);

    return Action.Continue;
});

classUnderTest.fetchLocalData(dirscan, destination);