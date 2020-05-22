Timer t = new javax.swing.Timer(2000, new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e){
        yourLabel.setText(...);
    }
});
t.start();