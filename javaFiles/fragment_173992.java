DocumentPreprocessor dp = ...
for (HasWord hw : dp) {
  if (hw.word().equals(args[1])) {
    System.err.println("Yes!");
  }
}