class SelectionListener implements ActionListener {
    private JComponent monthlyRadioButton;
    private JComponent loanAmountButton;

    public SelectionListener(JComponent monthlyRadioButton, JComponent loanAmountButton) {
        this.monthlyRadioButton = monthlyRadioButton;
        this.loanAmountButton = loanAmountButton;
    }

    public void actionPerformed(ActionEvent event){
        if(event.getSource() == monthlyRadioButton)
            System.out.println("You clicked Monthly");
        else if(event.getSource() == loanAmountButton)
            System.out.println("You clicked Loan Amount");
    }
}