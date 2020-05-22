class MyJCheckBox extends JCheckBox {
  private Object o;
  public Object getObject() { return o; }
  public void setObject(Object o) { this.o = o; }
  // add necessaries ctors
}

// somewhere else
MyJCheckBox j = new MyJCheckBox(...);
j.setObject(...);
j.addActionListener(new MyListener());

class MyListener implements ActionListener {
  actionPerformed(ActionEvent e) {
    MyJCheckBox jcb = (MyJCheckBox)(e.getSource());
    Object o = jcb.getObject();
  }
}