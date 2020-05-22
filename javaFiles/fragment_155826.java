MyDialog dialog = new MyDialog();        
dialog.addWindowListener(new WindowAdapter() {
    @Override
    public void windowClosing(final WindowEvent event) {
        System.out.println(event);
        if (shouldClose()) {
            dialog.close();
        }
    }
});