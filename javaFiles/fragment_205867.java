int wrongInputCounts = 0 ;
//for loop that gets the 5 numbers from the user
for(counter = 0; counter < 5; counter++){

    try{

        num = Integer.parseInt(JOptionPane.showInputDialog("Enter number "+(counter+1)));

    }catch(NumberFormatException e){
        wrongInputCounts++;
        JOptionPane.showMessageDialog(null,num + " is not a valid number");
    }
}