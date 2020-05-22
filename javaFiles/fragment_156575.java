String home = System.getProperty("user.home");
Path fifoPath = Paths.get(home + "/myFifo");
try {
    Files.delete(fifoPath);
} catch (Exception ex) {
    System.err.println(ex);
}