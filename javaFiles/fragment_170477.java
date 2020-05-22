calculateButton.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent e) {
        if (selection.getSelection().equals(monthlyRadioButton.getModel())) {
             monthlyPaymentField.setValue(new Double(12.22));
            System.out.println("You selected monthly");
        } else {
            loanAmountField.setValue(new Double(12.22));
            System.out.println("You selected loan");
        }
    }
});