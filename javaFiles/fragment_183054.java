final List<String> labelNames = new ArrayList<String>();
MouseListener listener = new MouseAdapter() {
  @Override
  public void mouseClicked(MouseEvent e) {
    if (e.getSource() instanceof JLabel){
      labelNames.add(((JLabel) e.getSource()).getText());
    }
  }
};
JLabel label1 = new JLabel();
label1.addMouseListener(listener);
JLabel label2 = new JLabel();
label1.addMouseListener(listener);
JLabel label3 = new JLabel();
label1.addMouseListener(listener);