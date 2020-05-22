int number; // some number
char[] numChars = Integer.toString(number).toCharArray();
int arr[] = new int[numChars.length];

for (int i = 0; i < numChars.length; ++i) {
    arr[i] = numChars[i] - '0';
}