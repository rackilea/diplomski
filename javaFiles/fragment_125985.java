try {
    ...
    // Code that may throw a few types of exceptions
    ...
} catch(FileNotFoundException fnfe) {
    // handle very specific exceptions
} catch (IOException ioe) {
    // handle less specific exceptions
} catch (Exception e) {
    // handle the most generic exception case
}