while (true) {
  try {
    setEmail(emailAddress);
    break;
  } catch (IllegalArgumentException e) {
    // Show a message, or whatever.
  }