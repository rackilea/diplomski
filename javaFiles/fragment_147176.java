private synchronized boolean isGameStarted() {
  return gameStarted;
}

...
try {
  while (!isGameStarted()) {
...