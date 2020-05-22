public static void main(String[] args) {
    char[] arr = new char[26];
    int j = 0;
    for (char i = 'a' ; i <= 'z' ; i++) {
        arr[j] = i;
        j++;
    }
    for (int k = 0; k < arr.length; k++) {
        System.out.println(arr[k]);
    }
}