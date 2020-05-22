public static void main(String[] args) {

    String[] arr = { "hello", "how", "hello", "to", "how", "me", "in" };
    Arrays.sort(arr);

    int counter = 1;
    for (int j1 = 0; j1 < arr.length; j1++) {

        int j2 = j1 + 1;
        String next = (j2 < arr.length) ? arr[j2] : null;

        if (arr[j1].equals(next)) {
            counter++;
        } else {
            System.out.println(arr[j1] + " " + counter);
            counter = 1;
        }
    }       
}