String[] arrayOfStrings = {"abcde", "fghij", "klmno"}; //each string is long 5
String totalString = arrayOfString[0] + "|" + arrayOfString[1] + "|" + arrayOfString[2]; // the result is abcde|fghij|klmno

//now I split the strings from the total to a new array:
String[] newArrayOfStrings = totalString.split("|");

System.out.println(newArrayOfString[0] + newArrayOfString[1] + newArrayOfString[2]); // this will output "abcdefghijklmno"