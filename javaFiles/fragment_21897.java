JButton btn = new JButton();
btn.setActionCommand(row + "x" + column);
btn.addActionListener(new ActionListener(){
    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        //...
    }
});