public static void main(String[] args) {
    String stringToSplit = "99E0L";
    String[] arr = stringToSplit.split("(?<=\\G\\d{2})");
    for (String s : arr) {
        System.out.println(s);
    }
}