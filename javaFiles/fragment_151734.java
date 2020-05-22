boolean clicked = false;
label2.addMouseListener(new MouseAdapter(){
        @Override
         public void mouseClicked(MouseEvent e) {
                //return to start()
                clicked = true;
            }
    });