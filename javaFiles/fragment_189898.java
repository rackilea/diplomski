try {  
    int input3 = Integer.parseInt(input6);

    //....
    //switch block
    //..
}
catch(NumberFormatException nfe){
    JOptionPane.showMessageDialog(null,"You entered an invalid operation.  Please select 1, 2, or 3.");
    continue;   // go to beginning of loop
}