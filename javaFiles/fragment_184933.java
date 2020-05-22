do{
        uniqueCheck = 0;
        userGuessAsString = JOptionPane.showInputDialog(compNum + "\n Please enter a number.");
    int number = Integer.parseInt(userGuessAsString);

    // put three digit number individually into array
    for(int loop = (userNumber.length - 1); loop>=0; loop--){
        userNumber[loop]= number%10;
        number = number/10;
    } // end userNumber array populating

    for (int loop = 0; loop < userNumber.length; loop++){
        for(int innerLoop  = 0; innerLoop < userNumber.length; innerLoop++) {
            if(loop != innerLoop) {
                if (userNumber[loop] == userNumber[innerLoop] ){
                    JOptionPane.showMessageDialog(null, "Please enter three unique digits!", "ERROR", JOptionPane.ERROR_MESSAGE);
                    uniqueCheck ++;
                } //  end inner IF loop
            } // end outer IF loop
        } // end inner for loop
    } // end outer for loop

    } while (uniqueCheck > 0);