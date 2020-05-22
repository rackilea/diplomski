private static final List<Integer> ACCEPTED_KEYS = Arrays.asList(KeyEvent.VK_ENTER, ...);

public void keyPressed(KeyEvent event) {
  if (ACCEPTED_KEYS.contains(event.getKeyCode())
    // do something
}