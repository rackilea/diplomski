private class ButtonHandler implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e){
        System.out.println((JButton)e.getSource().getText());
    }
}