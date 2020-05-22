btnGo.addMouseListener(new MouseAdapter() {
 @Override
 public void mouseClicked(MouseEvent e) {
  ThreadTest t = new ThreadTest();
  t.start();
  }
});