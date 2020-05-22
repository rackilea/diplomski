final MyX myX = new MyX(x);
JButton changeValue= new JButton("Change the value of x");
changeValue.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        myX.setX(10);
    });
// get the value of MyX back if necessary