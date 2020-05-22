private static Scanner sc = new Scanner(System.in);

public static void main(String[] args) {

    String pattern, target;
    System.out.println("Enter Target String: ");
    target = sc.nextLine();
    System.out.println("Enter pattern to be searched: ");
    pattern = sc.nextLine();
    searchPattern(pattern, target);
}

public static void searchPattern(String pattern, String target) {
    Pattern p = Pattern.compile(pattern);
    Matcher m = p.matcher(target);
    int count = 0;
    while (m.find()) {
        count++;
        System.out.println(m.start() + "--" + m.end() + "--" + m.group());
    }
    if (count == 0) {
        System.out.println("Your pattern was not found in the target string");
    } else {
        System.out.println("Total occurrences of " + pattern + " are" + count);
    }
}