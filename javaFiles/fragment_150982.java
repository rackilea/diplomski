private static List<String> permutations;

public static void main(String[] args) {
    permutations = new ArrayList<>();
    printPermutn("123", "");

    System.out.println();
    System.out.println("permutations BEFORE sorting");
    System.out.println(permutations);

    // sort
    Collections.sort(permutations, Collections.reverseOrder());

    System.out.println("permutations AFTER sorting");
    System.out.println(permutations);
}

// Function to print all the permutations of str
static void printPermutn(String str, String ans) {
    // If string is empty
    if (str.length() == 0) {
        System.out.print(ans + " ");
        permutations.add(ans);
        return;
    }

    for (int i = 0; i < str.length(); i++) {

        // 1st character of str
        char ch = str.charAt(i);

        // Rest of the string after excluding
        // the 1st character
        String ros = str.substring(0, i) + str.substring(i + 1);

        // Recurvise call

        printPermutn(ros, ans + ch);
    }
}