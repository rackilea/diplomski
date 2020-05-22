enter.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e){
        hrsIn = Integer.parseInt(hourField.getText());
        daysIn = Integer.parseInt(dayField.getText());
        monthsIn = Integer.parseInt(monthField.getText());
        yearsIn = Integer.parseInt(yearField.getText());
        timeAdd = Integer.parseInt(timeAdded.getText());

        String result = Basic.addTimeTo(yearsIn, monthsIn, daysIn, hrsIn, timeAdd);

        JOptionPane.showMessageDialog(frame, result);
    }
});