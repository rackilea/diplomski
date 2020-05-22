//code to create buttons and to place them on the frame / panel
for(int y = 0; y < 8; y++){
    for(int x = 0; x < 8; x++){
        JButton b = new JButton();
        //place the JButton on your frame / panel
        //probably you are using a GridLayout
        b.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                if(mine[y][x] == 9){
                    b.setText("B");
                    b.setEnabled(false);
                }
            }
        });
    }
}