mesa[i][j].setIcon(image);
mesa[i][j].addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        //Execute when button is pressed
        mesa[i][j].setBackground(Color.RED);

        }
});