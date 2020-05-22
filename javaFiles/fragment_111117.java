button.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        String name = names[(int) (Math.random() * names.length)]; 
        label.setText(name);
    }
});