....
private Composite dataCalcComposite;

public void createContents() {
  dataCalcComposite = new Composite(shell, SWT.NONE);
  dataCalcComposite.setBounds(0, 10, 279, 146);
}

public void repositionObjects() {
  if (dataCalcComposite != null) {
      dataCalcComposite.setLocation(50, 10)
  }
}
....