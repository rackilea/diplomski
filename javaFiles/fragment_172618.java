private void createPanel() {
    buttonPanel = new JPanel();
    ProcessSelection = new JButton("Process Selection");
    ProcessSelection.addActionListener(new calButton());
    buttonPanel.add(ProcessSelection);
    add(buttonPanel, BorderLayout.SOUTH);
}