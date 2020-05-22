for(int i=0;i<30;i++){
        buttons[i] = new JButton("label"+ i);
        buttons[i].setBackground(Color.white);
        if (i < 10) {
           if (i%2 == 0) {
             buttons[i].setIcon(piece2);
           } else {
             buttons[i].setIcon(piece1);
           }
        }
        panel.add(buttons[i]);
    }