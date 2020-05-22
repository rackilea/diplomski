try (Statement stmt = con.createStatement()) {
    throw new RuntimeException("foo");
} catch (Exception e) {
    // Here e is my RuntimeException, if stmt.close() failed
    // I can get the related exception from e.getSuppressed()
}