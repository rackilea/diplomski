for (String text : fileList) {
   JRadioButton btn = new JRadioButton(text);
   btn.setActionCommand(text); // radiobuttons don't do this by default
   buttonGroup.add(btn);  // ButtonGroup to allow single selection only
   myRadioPanel.add(btn); // JPanel usually uses a GridLayout
}
// if myRadioPanel is already in the GUI, then revalidate and repaint it