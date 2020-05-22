private void writeRecord() {

    String l_employeeName;
    Double l_hourlyRate;
    Integer l_employeeNumber, l_regularHours, l_overtimeHours;


 // this is where I am having errors. It is saying that the getText method is undefined
 // for each respective use (int, string, double). I am also getting error "The method
 // writeString(String) is undefined for the type DataOutputStream" and the same 
 // undefined errors for the setText for each respective use. 

    try {
        l_employeeName = String.parseString(employeeName.getText());
        l_employeeNumber = Integer.parseInt(employeeNumber.getText());
        l_hourlyRate = Double.parseDouble(hourlyRate.getText());
        l_regularHours = Integer.parseInt(regularHours.getText());
        l_overtimeHours = Integer.parseInt(overtimeHours.getText());
        ostream.writeString(l_employeeName);
        ostream.writeInt(l_employeeNumber);
        ostream.writeDouble(l_hourlyRate);
        ostream.writeInt(l_regularHours);
        ostream.writeInt(l_overtimeHours);
        employeeName.setText("");
        employeeNumber.setText("");
        hourlyRate.setText("");
        regularHours.setText("");
        overtimeHours.setText("");