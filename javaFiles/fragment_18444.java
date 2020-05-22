String myString = "17-08-2015 13:28:41 -0400Bill Amount: 56.23      Tip Amount: 11.25  Total Amount: 67.48     Bill Split: 1 Tip Percent: 20.00 ";
String substrings[] = {"Bill Amount: ", "Tip Amount: ", "Total Amount: ", "Bill Split: ", "Tip Percent: "};
String results[] = new String[5];

for (int i = 0; i < substrings.length; i++){
    int index = myString.indexOf(substrings[i]) + substrings[i].length(); // where to start looking
    String result = myString.substring(index, myString.indexOf(" ", index));
    results[i] = result;
}