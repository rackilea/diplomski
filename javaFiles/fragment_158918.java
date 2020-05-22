String[] arrayOfStrings = {"abcde", "fghij", "klmno"}; //each string is long 5
String totalString = arrayOfString[0] + arrayOfString[1] + arrayOfString[2]; // parenthesis not needed

// now if I want to came back to the original three I have to do like this:
String[] newArrayOfStrings = new String[3]; // I create a new array that has to be filled with the original 3 strings
newArrayOfStrings[0] = totalString.substring(0,5); //cut the first part, from character number 0 incluse to character number 5 excluse (from 0 to 4)
newArrayOfStrings[1] = totalString.substring(5,10);
newArrayOfStrings[2] = totalString.substring(10,15);

System.out.println(newArrayOfString[0] + newArrayOfString[1] + newArrayOfString[2]); // this will output "abcdefghijklmno"

// you can do that process also with a cycle (if you have more than three strings together

for(int i = 0, i < arrayOfStrings.length ; i++){
    newArrayOfStrings[i] = totalString.substring((i* 5),5+(i*5));
}