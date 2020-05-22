JButton add = new JButton("Add");
JButton cancel = new JButton("Cancel");

cancel.setEnabled(false);

// Then something along these lines...
add.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        cancel.setEnabled(true);
    }
});