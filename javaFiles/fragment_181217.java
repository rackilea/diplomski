int counter = 0;
String input = "Pool";
char replacement = 'l';
char[] inputArray = input.toCharArray();
for(char ch : inputArray) {
    if(ch == 'o') {
        inputArray[counter] = replacement;
    }
    counter += 1;
}
String output = new String(inputArray);
System.out.println(output);