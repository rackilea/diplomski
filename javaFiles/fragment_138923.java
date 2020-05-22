public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String str = input.nextLine();

    // Whatever is the input it take the first character.
    char searchKey = input.nextLine().charAt(0);
    countString(str, searchKey);
}

public static void countString(String str, char searchKey) {
    // The count show both number and size of occurrence of searchKey
    String count = ""; 
    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == searchKey)
            count += str.charAt(i) + "\n";
    }
    System.out.println(count + "\nNumber of Occurrence of "
                    + searchKey + " is " + count.length() + " in string " + str);
}