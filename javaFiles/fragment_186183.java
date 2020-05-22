static void search(final SearchListener listener) {
  final ProgressWindow window = new ProgressWindow();
  window.setVisible(true);

  Thread t = new Thread(new Runnable() {
    @Override
    public void run() {
        search(listener, window);
    }
  });
  t.start();
}