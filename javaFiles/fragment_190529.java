while (gameIsRunning) {
  int timeElapsed = timeSinceLastUpdate();
  for (GameEntity e : entities) {
    e.update(timeElapsed);
  }
  render(); // or simply repaint in your case, I guess
  Thread.sleep(???); // You don't want to do this on the main Swing (EDT) thread though
}