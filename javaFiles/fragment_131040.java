String formatedString = employeeRecords.get(row).toString()
    .replace(",", "")  //remove the commas
    .replace("[", "")  //remove the right bracket
    .replace("]", "")  //remove the left bracket
    .trim();  
employeeDisplay.setText(formatedString);