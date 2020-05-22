// Waiting 30 seconds for an element to be present on the page, checking
  // for its presence once every 5 seconds.

  Wait wait = new FluentWait(driver)
    .withTimeout(30, SECONDS)
    .pollingEvery(5, SECONDS)
    .ignoring(NoSuchElementException.class);