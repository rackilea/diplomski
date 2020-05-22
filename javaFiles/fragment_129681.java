JLabel l = ...;
JSpinner spinner = ...;
spinner.addChangeListener(new ChangeListener() {
  public void stateChanged(ChangeEvent e) {
    l.setText("Counter = " + spinner.getValue());
  }
}