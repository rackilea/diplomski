public class TestClass {

    private boolean isButtonClicked = false;

    public void testYourButtons() {

        JButton myButton = new JButton();
        myButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                isButtonClicked = !isButtonClicked;
            }
        });

        myButton.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent arg0) {
                // TODO Auto-generated method stub  
            }

            @Override
            public void keyReleased(KeyEvent arg0) {
                // TODO Auto-generated method stub
            }

            @Override
            public void keyPressed(KeyEvent arg0) {
                if (isButtonClicked) {
                    // TODO Do here your event handling
                    isButtonClicked = false;
                }
            }
        });

    }

}