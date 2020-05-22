static int[] codePoints(String s) {
    int n = s.length();
    int[] temp = new int[n];
    for (int i = 0; i < n; i++)
        temp[i] = s.codePointAt(i); // <-- HERE
    return temp;
}