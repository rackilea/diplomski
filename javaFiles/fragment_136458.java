catch (TimeoutException tox) {
    tox.printStackTrace();
    if(tox.getCause() instanceof NoSuchElementException) {
      NoSuchElementException nse = (NoSuchElementException) tox.getCause();
      ...
    }
}