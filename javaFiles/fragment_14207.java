public static void main(String[] args) {
    System.out.println(isPermutation("hello", "olleh"));
    System.out.println(isPermutation("hell", "leh"));
    System.out.println(isPermutation("world", "wdolr"));
}

private static boolean isPermutation(String a, String b) {
    char [] aArray = a.toCharArray();
    char [] bArray = b.toCharArray();
    Arrays.sort(aArray);
    Arrays.sort(bArray);
    return Arrays.equals(aArray, bArray);
}