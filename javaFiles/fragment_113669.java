public class StackOverflowExample {
    public static void main(String[] args) {
        // This is a source string example
        StringReader stringReader = new StringReader("\"field_name\":\"field_value\"");
        // The scanner instance with default values
        Scanner scanner = new Scanner(stringReader);
        // Compile the pattern to match field names
        Pattern field_name_pattern = Pattern.compile("\"\\w+\":");
        // Check if scanner finds the first field name
        String field_name = scanner.findInLine(field_name_pattern);
        if (field_name != null) {
            // Field name found, so print it
            System.out.println(field_name);
        } else {
            // Field name not found, so warn about it
            System.out.println("Oops! It didn't work!");
        }
    }
}