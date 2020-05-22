// Define the input as an array of input strings and print result
// by iterating the input array elements
String [] inputStrings = {"6,8 ,9 , 10", "1002", "", ", 2", "Ett,Två", "1,,2", "1 , 2 ,"};
for (String input : inputStrings) {
    int [] result = str2ia(input);
    if (result == null) {
        System.out.println("");
    }
    else {
        System.out.println(Arrays.toString(result));
    }
}