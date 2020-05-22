boolean doItFirst = evaluateOnce();
if (doItFirst) {  // or get rid of the temporary variable
    files = listFiles();
    changeDirectory();
} else {
    changeDirectory();
    files = listFiles();
}