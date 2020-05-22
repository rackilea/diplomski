class Action implements ActionListener{
    private JButton buttonToUpdate;

    public Action(JButton buttonToUpdate) { 
        this.buttonToUpdate = buttonToUpdate;
    }

    public void actionPerformed(ActionEvent e){
        buttonToUpdate.setBackground(randomColor());
    }
}