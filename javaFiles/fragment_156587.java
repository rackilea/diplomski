while (true) {
  try {
    //
    break;
  } catch (Exception e ) {
    if (--numTries == 0) throw e;
  }
}