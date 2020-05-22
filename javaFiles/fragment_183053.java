// ActionListener implementation that maintains a reference to each JCheckBox.
// We will register this listener with the Submit button.
public class MyActionListener implements ActionListener {
  private final List<JCheckBox> checkBoxes = new LinkedList<JCheckBox>();

  /**
   * Adds the specified JCheckBox to the list of JCheckBoxes.
   */
  public void addCheckBox(JCheckBox checkBox) {
    this.checkBoxes.add(checkBox);
  }

  /**
   * Called when the Submit button is pressed.
   */
  public void actionPerformed(ActionEvent evt) {
    StringBuilder sb = new StringBuilder();
    sb.append("Selected Check Boxes: ");

    // Iterate over each JCheckBox and build message ready for display.
    // Could do something more sophisticated here if required.
    for (JCheckBox checkBox : checkBoxes) {
      if (checkBox.isSelected()) {
        sb.append(checkBox.getText()).append(' ');
      }
    }

    JOptionPane.showMessageDialog(null, sb);
  }
}

// 1. Create ActionListener implementation.
MyActionListener al = new MyActionListener();

// 2. Register JCheckBoxes with ActionListener.
al.addCheckBox(checkBox);
// etc.

// 3. Finally register ActionListener with Submit button.
submitButton.addActionListener(al);