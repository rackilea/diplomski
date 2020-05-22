Random rn = new Random();
int minimum = 97; // the byte code of ASCII 'a'
int n = 26; //Letters in the ABC

String newString = "";
for (int i = 0; i < oldString.length; i++){
    int k = rn.nextInt(n);
    randomNum =  minimum + k;
    newString += oldString.charAt(i);
    newString += (char)randomNum;
 }