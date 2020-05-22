final Timer t = new Timer(100, p);  // need to make this final to avoid compile error
f.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosed(WindowEvent e) {
        t.stop();
    }
});