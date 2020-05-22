EventQueue.invokeLater(new Runnable() {
    @Override
    public void run() {
        Constraints constraints = new Constraints();
        constraints.displayGUI();
        System.out.println("Hello world");
    }
});