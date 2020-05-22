final List<Button> subordinateButtons = Arrays.asList(new Button(), new Button(), new Button());
Button myButton = new Button();
myButton.addMouseListener(new MouseListener() {

    public void mouseEntered(MouseEvent e) {
        for (Button subordinateButton : subordinateButtons) {
            subordinateButton.setBackground(Color.GRAY);
        }
    }

    public void mouseExited(MouseEvent e) {
        for (Button subordinateButton : subordinateButtons) {
            subordinateButton.setBackground(Color.LIGHT_GRAY);
        }
    }

    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
    }

    public void mouseReleased(MouseEvent e) {
    }

});