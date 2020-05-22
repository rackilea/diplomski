try (Formatter file = new Formatter("Records.txt")) {
    // do stuff with file here

} catch(FileNotFoundException fileNotFoundException) {
      System.err.println("File not found.");
} catch(SecurityException securityException) {
      System.err.println("Do not have required permission.");
} catch(FormatterClosedException formatterClosedException) {
      System.err.println("File is already closed.");
} catch(IllegalStateException illegalStateException) {
      System.err.println("Error reading from file.");
}