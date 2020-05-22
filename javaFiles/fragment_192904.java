writeFooter(...) {

  try {
    openStreams();
    writeToFile();
  } finally {
    closeStream();
  }
}