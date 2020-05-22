runone = new Runnable() {
    @Override
    public void run() {
        frame.getContentPane().removeAll();
        frame.add(button2);
        frame.validate();
    }
};