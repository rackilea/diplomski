timer = new Timer(DELAY, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        for (Shape shape : shapes) {

            shape.move();

        }
    }
});