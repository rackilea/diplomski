class YourClass {
    int firstSet = 0; // global attribute!

    public void yourListenerMethod() {
        // if firstSet == 0 is first attempt
        if (firstSet == 0) {
            firstSet = Integer.parseInt(jTextField2.getText());
            jTextField2.setText("");
            jLabel1.setText("Re-Enter PIN");
        //
        // if firstSet != 0 is second attempt so compare
        } else {
            int secondSet = Integer.parseInt(jTextField2.getText());
            if(firstSet==secondSet)
            {
                jLabel1.setText("PIN VERIFIED");
                // reset the pin if necessary
                firstSet = 0;
            }
            else
            {
                jLabel1.setText("PIN INCORRECT");
                // reset the pin if necessary
            }
        }
    }
}