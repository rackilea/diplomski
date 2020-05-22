class MyAction extends AbstractAction {
  public static final String MY_KEY = "MY_KEY";
  public void actionPerformed(ActionEvent e) {
    Object o = this.getValue(MY_KEY);
  }
}

// somewhere else
JCheckBox j = new JCheckBox(...);
MyAction a = new MyAction(...);
a.putValue(MyAction.MY_KEY,some_object);
j.addAction(a);