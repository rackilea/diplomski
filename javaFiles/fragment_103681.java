SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        jLabel1.setText("Yay I'm on the EDT.");
    }
});