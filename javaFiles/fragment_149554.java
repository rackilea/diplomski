txtGrade.addActionListener(new ActionListener(){
  public void actionPerformed(ActionEvent e) {
    try{
        al.add(Integer.parseInt(txtGrade.getText()));
        txtGrade.setText("");
        numOfGrades++;
        lblGRecord.setText(numOfGrades + " Grades Recorded");
    } catch(Exception ex){
        JOptionPane.showMessageDialog(this, "Please enter a number");
        txtGrade.selectAll();
    }
    txtGrade.requestFocusInWindow();
  }
});