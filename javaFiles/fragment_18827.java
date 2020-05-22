@Override
    public void actionPerformed(ActionEvent e) {
      try {
        if(e.getSource() == submitButton) {
        System.out.println(KillWellCalculations.pumpEfficiency);
        // THE REFERENCES THAT THIS STATIC METHOD USE WERE ALL GARBAGE-COLLECTED AT THE TIME OF THE CALL... IF SHOULD HAVE THE CALCULATED METHODS IN THE VALUE CLASS. SOMETHING LIKE THE FOLLOWING:
        // KillWellCalculations.setPressureBeforeCasingBurstAndFormationFracture(); //Doesn't work
        //KillWellCalculations.setCirculatingPressures();
        //KillWellCalculations.setTriplexPumpCapacity();
        //System.out.println(KillWellCalculations.mudInActivePits);
        //System.out.println(KillWellCalculations.pumpFactor);
        //System.out.println(KillWellCalculations.finalCirculatingPressure);}

        // DO THE FINAL CALCULATION IN A SINGLE METHOD IN THE VALUE OBJECT.
        calculatedValues.doAllCalculations();

        // HERE ARE THE GETTERS FROM THE CALCULATED VALUES OF THE DO ALL CALCULATIONS YOU HAVE TO IMPLEMENT.
        System.out.println(calculatedValues.getMudInActivePits());
        System.out.println(calculatedValues.getPumpFactor());
        System.out.println(calculatedValues.getFinalCirculatingPressure());}

        // CONSIDERING YOU'RE DONE WITH THE VALUES, JUST CLEAR THE INSTANCE VALUES
        // AS THIS REFERENCE IS NOT STATIC AND IT WILL NOT BE GARBAGE-COLLECTED. 
        calculatedValues.clearValues();
    }
    catch(Exception ignore) {}
  }