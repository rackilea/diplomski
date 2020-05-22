JButton myButton = new JButton("Press Here!");
myButton.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent event){
        jLabel9.setIcon(new ImageIcon("newPath"));
    }
});