btnGo.addMouseListener(new MouseAdapter() {
 @Override
 public void mouseClicked(MouseEvent e) {
  Thread t = new Thread(new RunnableTest());
  t.start();
  }
});