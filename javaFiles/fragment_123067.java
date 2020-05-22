JFrame frame = ...
frame.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(WindowEvent e) {
        // close sockets, etc
    }
});