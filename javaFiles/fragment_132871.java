final Object aa = "new value";
SwingUtilites.invokeLater(new Runnable() {
    public void run() {
        model.setValueAt(aa, 0, 0);
        System.out.println(model.getValueAt(0, 0));
    }
});