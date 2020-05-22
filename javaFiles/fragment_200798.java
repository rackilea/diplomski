public static int[] myLengths(String[] myString) {
int x = myString.length;
int[] y = new int[x];

for(int i = 0; i < x; i++) {
    y[i] = myString[i].length();
}   

return y;
}