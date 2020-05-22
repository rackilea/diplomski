try {
        ....////
    }
    catch (NumberFormatException nfe) {
        throw new NumberFormatException("The value you entered, " + value+ " is invalid.");
    }