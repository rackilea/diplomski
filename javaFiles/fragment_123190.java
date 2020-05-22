class frame extends JFrame{

    frame(){

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if(e.getExtendedKeyCode() == KeyEvent.VK_SPACE){

                    //insert here the code you'd like to be executed when the user introduces a spacebar

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
      setVisible(true);
    }

}