// Note you must use final method arguments to be available inside an anonymous class
private void changeJLabel(final JLabel label, final String text) {
  EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
      myLabel.setText(text);
    }
  });
}