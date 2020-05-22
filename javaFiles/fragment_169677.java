case USER_CHOIDE_AMPERAGE:
    System.out.println("Please enter the Voltage:");
    myCircuit.setVoltage(keyboard.nextDouble());
    System.out.println("Please enter the Resistance:");
    myCircuit.setResistance(keyboard.nextDouble());
    myCircuit.calcAmperage(); // ADD THIS LINE
    System.out.println("The value of Amperage is: " + myCircuit.getAmperage());
    break;