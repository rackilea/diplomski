public void actionPerformed(ActionEvent e)
    {
        String dyStr = changeTF.getText();
        change = Integer.parseInt(dyStr);
        while (change != 0)
        {
            while (change >= 25)
            { //Subtact & Count Quarters
                change = change - QUARTERS;
                quarters++;
            } //Subtract & Count Dimes
            while (change >= 10)
            {
                change = change - DIMES;
                dimes++;
            } //Subtract & Count Nickels
            while (change >= 5)
            {
                change = change - NICKELS;
                nickels++;
            }
            pennies = change;
        }

        // Update the JLabels to display the result
        quartersL.setText("" + quarters);
        dimesL.setText("" + dimes);
        nickelsL.setText("" + nickels);
        penniesL.setText("" + pennies);

    }