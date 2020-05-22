//create a button which will hide the panel when clicked.
JButton b = new JButton("HIDE");
b.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
            p.setVisible(false);
    }
});