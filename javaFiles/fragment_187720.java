btnParent.addActionListener(event -> {
    panelParent.remove(myPanel);
    grandPanel.remove(myPanel);
    grandPanel.revalidate();
    grandPanel.repaint();
});