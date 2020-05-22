class listener implements ActionListener {

    private DefaultTableModel model;

    listener(DefaultTableModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int empNum = 0;
        double hourlyRate = 0;
        double hoursWorked = 0;
        double payAMT = calculatePay(hourlyRate, hoursWorked);

        model.addRow(new Object[]{empNum, hourlyRate, hoursWorked, payAMT});
    }
}