class listener implements ActionListener {

    private DefaultWorkSheetTableModel model;

    listener(DefaultWorkSheetTableModel model) {
        this.model = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int empNum = 0;
        double hourlyRate = 0;
        double hoursWorked = 0;
        //...
        DefaultEmployee employee = new DefaultEmployee(empNum, hourlyRate, hoursWorked);
        model.add(employee);
    }
}