ActionListener al = new ActionListener(){
    public void actionPerformed(ActionEvent ae) {
        if (board1) {
            getContentPane().add(gameBoard, BorderLayout.CENTER);
        } else {
            getContentPane().add(gameBoard2, BorderLayout.CENTER);
        }
    }
};
buttonSwitch.addActionListener (al);