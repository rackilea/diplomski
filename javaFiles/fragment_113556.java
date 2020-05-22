boolean make = false;

makeButton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent){
        make = true;
    }
});

missButton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent){
        make = false;
    }
});