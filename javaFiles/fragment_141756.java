String input = "hello";

char[] myArray = input.toCharArray();

for (int i = 0; i < myArray.length; i++) {
    for (int j = 1; j < myArray.length; j++) {
        if (myArray[i] > myArray[j]) {
            char temp = myArray[j];
            myArray[j] = myArray[i];
            myArray[i] = temp;
        }
    }
}
System.out.println(new String(myArray));