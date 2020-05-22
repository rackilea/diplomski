double inputNumber;
try {

    // some code

    inputNumber = Double.parseDouble(inputString);

    // here you are sure inputNumber was parsed successfully

} catch (NumberFormatException e) {

    // do something to tell the user about his error (or not)
    System.err.println("wrong input");

    inputNumber = 0;
}

// do something with inputNumber (it is either 0 or the input number here)