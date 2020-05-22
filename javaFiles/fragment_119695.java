addNewDialog.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosed(WindowEvent e) {
        refreshMainView();
    }
});