JButton button = new JButton("Clear TextField");
button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        textfield.setText("");
        //textfield.setText(null); // or try this
    }
});