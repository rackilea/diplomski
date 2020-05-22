for (int i = 0; i < 10; i++) { 

    // make it final so that it is accessible from inner anon class
    final JPanel myPanel = new JPanel();
    panelParent.add(myPanel);
    grandPanel.add(myPanel);

    JButton btnParent = new JButton("X");
    myPanel.add(btnParent);

    btnParent.addActionListener(event -> panelParent.remove(myPanel));
}