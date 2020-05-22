String decisionInput;
    decisionInput = keyboard.nextLine().toUpperCase();
    try{
        decision = Decisions.valueOf(decisionInput);
    } catch(IllegalArgumentException e){
        decision = Decisions.NOTVALID;
    }
    // Rest of your code...