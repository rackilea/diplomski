String someString = "";

myButton.addActionListner(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
       //this will give you myText's contents. Do what you will with them.
       someString = myText.getText();
    }
});