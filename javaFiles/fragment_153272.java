EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        Main m = new Main();
        m.setVisible(true);
    }
});