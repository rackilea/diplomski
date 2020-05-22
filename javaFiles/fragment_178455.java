public static boolean Check() {
    String random;
    Scanner sc = new Scanner(System.in);
    random = sc.nextLine();
    String word = "john";
    sc.close();

    int findIndex = 0;
    char findChar = word.charAt(findIndex);
    for (char c : random.toCharArray()) {
        if (findChar == c) {
            findIndex++;
            if (findIndex == word.length()) {
                return true;
            }
            findChar = word.charAt(findIndex);
        }
    }
    return false;
}