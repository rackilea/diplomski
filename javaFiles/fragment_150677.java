checkBoxes[t].addActionListener(new ActionListener() {
  public void actionPerformed(ActionEvent  e) {
    boolean selected = checkBoxes[t].isSelected();
    System.out.println("Approved"+selected);

    int index = -1;
    for (int i = 0; i < checkBoxes.length; i++) {
      if (checkBoxes[i] == e.getSource()) {
        index = i;
        // do something with i here
      }
    }
  }
});