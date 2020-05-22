EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        //overwrite existing variables, update GUI elements, trigger repaints, etc.
        dialog.setVisible(false);
    }
};