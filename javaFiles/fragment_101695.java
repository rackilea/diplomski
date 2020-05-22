public String getDoctorQuote() {

    String quote = "";  //  declare the variable before 
    Random randomGenerator = new Random();
    int randomNumber = randomGenerator.nextInt(3);

    // Use that value to choose which of the Doctors to get a quote from
    if (randomNumber == 0) {
        // Quote from Nine
        quote = mNine.getQuote();
    }
    else if (randomNumber == 1) {
        // Quote from Ten
        quote = mTen.getQuote();
    }
    else if (randomNumber == 2) {
        // Quote from Eleven
        quote = mEleven.getQuote();
    }
    else {
        quote = "Error";
    }
    return quote;
}