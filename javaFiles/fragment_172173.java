SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        scrollPane.getViewport().setViewPosition( new Point(0, 0) );
    }
});