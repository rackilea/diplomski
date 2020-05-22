private static void setButtons(){
    for (int i=0;i<=3;i++){
        buttons[i].setSize(10, 10);
        buttons[i].setLocation(0, 0);
        buttons[i].setVisible(true);

        buttons[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 // listener implement btn 0
            }
        });
    }
}