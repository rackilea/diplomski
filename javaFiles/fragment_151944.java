synchronized (r) {
  try {
    …
    r.wait(); // <- here you are waiting
  } catch (InterruptedException e) {
    …
  }
}
SwingUtilities.invokeLater(r); // <- never reached, you are waiting above