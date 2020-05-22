EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        MigLayoutMainWindow ex = new MigLayoutMainWindow();
        ex.setVisible(true);
    }
});