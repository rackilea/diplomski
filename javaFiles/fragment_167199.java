Command[] commands = null;  
    int randomNumber = 90;

    commands[0] = new CommandA(75);
    commands[1] = new CommandB(25);

    for(Command c: commands) {
        randomNumber -= c.getPercentage();
        if(randomNumber < 0) {
            c.executeCommand();
        }
    }