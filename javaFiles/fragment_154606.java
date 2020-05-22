int number = 324;
String number_string = String.valueOf(number); //converts integer to string
char[] digits = number_string.toCharArray();   //converts string to char array
if(digits[2] == 4){                            //checks if 3rd digit of the char array is 4 
  //do something
}