public JPanel results(StringBuilder message)
{   
    StringBuilder[] options = {message};
    // Create new JList
    showOption = new JList(options);
    // This is ill advised
    showOption.setLocation(300, 50);
    showOption.setSize(140,100);
    showOption.setVisibleRowCount(10);
    // What about the last JList?
    textPanel.add(showOption);