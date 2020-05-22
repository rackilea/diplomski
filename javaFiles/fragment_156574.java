Path fifoPath = Paths.get("/home/russell/myFifo");
try {
    Files.delete(fifoPath);
} catch (Exception ex) {
    System.err.println(ex);
}