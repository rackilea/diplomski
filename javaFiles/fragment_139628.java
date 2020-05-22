@Test
public void testCase2() throws Exception {
    CompletableFuture<String> cf = CompletableFuture.supplyAsync(() -> {
        if (true) throw new RuntimeException();
        return "Promise";
    });
    CompletableFuture<String> handledCf = cf.exceptionally((ex) -> {
        return "Fake Promise";
    });
    return handledCf.get();
}