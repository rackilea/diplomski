button1.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent evt) 
    {
        Module module = new Module();
        int text = module.totalHours();
        String textt = Integer.valueOf(text).toString();
        textfield9.setText(textt);
    }
});