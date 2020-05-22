SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        Color redBackground = redPanel.getBackground();
        redPanel.setBackground(orangePanel.getBackground());
        //...
        violetPanel.setBackground(redBackground);  
    }
});