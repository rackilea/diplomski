//event handling
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == avgBtn) {
        computeAverage();
        panel.repaint();
    }
}