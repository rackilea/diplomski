SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        MyClient.buttonBarFrame.requestFocusInWindow(); //so chat does not request focus
    }
});