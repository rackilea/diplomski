public static void main(String[] args) throws FileNotFoundException {
    System.out.println(isValidFirstChar("-test"));
    System.out.println(isValidFirstChar("\\test"));
    System.out.println(isValidFirstChar("\'test"));
    System.out.println(isValidFirstChar("test"));
}
public static final Pattern VALID_FIRST_CHARACTERS = Pattern.compile("^[\\\\ \\' \\-].*");

public static boolean isValidFirstChar(String name) {
    if (VALID_FIRST_CHARACTERS.matcher(name).matches()) {
        return true;
    }
    return false;
}