MyButton myButton = new MyButton();
// ...
myButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        MyButton button = (MyButton) e.getSource();
        int xPos = button.getXPos();
        int yPos = button.getYPos();
        // Do something with x and y
    }
});