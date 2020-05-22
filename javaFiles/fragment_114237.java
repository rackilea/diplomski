public static int yourFunction(ArrayList<Integer> list){
    String numbers = ""; // fill a string with your numbers

    for(Integer i : list){
        numbers += String.valueOf(i);
    } // could be nicer with java8 lambda function


    String tmp_numbers; // temporary string needed
    while(numbers.length() > 2){
        tmp_numbers = "";
        for(int i = 0; i < numbers.length()-1; ++i){
            // add two following numbers
            // substring to read digit by digit
            int v = Integer.parseInt(numbers.substring(i,i+1)); // first digit
                v += Integer.parseInt(numbers.substring(i+1,i+2)); // + second
            tmp_numbers = tmp_numbers + String.valueOf(v); // and fill the tmp string with it
        }
        numbers = tmp_numbers; // set the tmp string to our new beginning
    }
    return Integer.parseInt(numbers);
}