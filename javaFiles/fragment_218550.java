private void initGUI() {
    verticalPanel = new JPanel();
    verticalPanel.setLayout(new BoxLayout(verticalPanel, BoxLayout.Y_AXIS));

    setViewportView(verticalPanel); // ********** changed *******

    setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
    setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
}