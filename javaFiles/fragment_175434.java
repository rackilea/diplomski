public class Test {
    public static void main(String[] args) {
        String text = "\"'some \"other string\"'";
        String trimmed = text
            .replaceAll("^['\"]*", "")
            .replaceAll("['\"]*$", "");
        System.out.println(trimmed);
    }
}