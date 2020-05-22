public void calculateTotal() {
    String first;
    String second;

    double firstNum;
    double numerator = 0;
    double denominator = 0;

    // This loops counts from nos down to 1. It checks for empty strings and 
    //   sums up the numerator and denominator along the way.
    for(int index = nos; index > 0; index--) {
        first = arrayOfEditText[index].getText().toString();
        second = arrayOfEditText1[index].getText().toString();

        if(first.isEmpty() || second.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Dont leave any points empty (" + (index + 1) + ")", Toast.LENGTH_LONG).show();
            return; // Invalid input, warn user and bail out of function!
        }

        firstNum = Double.parseDouble(first);
        numerator += firstNum * Double.parseDouble(second);
        denominator += firstNum;
    }

    // Do something with total
    double total = numerator / denominator;
}