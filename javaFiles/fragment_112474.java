JBUtton button = new JButton("Button");
button.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e) {
        new OurputDisplay();                     <===== Created on EDT!!
    }
});