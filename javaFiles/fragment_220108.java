try {
    CharStream input = CharStreams.fromFileName(fileName);
} catch (final IOException e) {
    // Handle the exception.
    // For example: log (print to standard to error) it and return.
    System.err.println(e);
    return;
}