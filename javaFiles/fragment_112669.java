public class Main {
    private static final String REGEX = "\\[([^\\]]+)";
    private static final String INPUT = "10:11:22 [UTP][ROX][ID:32424][APP STR]";

    private static Pattern pattern;
    private static Matcher matcher;

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(INPUT);

        while (matcher.find()) {
            System.out.println(matcher.toString());
        }
    }
}