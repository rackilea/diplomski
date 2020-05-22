knopOptel.addActionListener((ActionEvent e) ->
{
    int invoerGetal = Integer.parseInt(invoerVak.getText()); // get the number
    calculate(invoerGetal); //sets totalNumber to what it should be by looking at the flags
    invoerVak.setText(totalNumber); // we write the temporary result
    additionFlag = true; // next number must be added
});