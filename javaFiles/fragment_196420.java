public class ScannerExample {
    public static void main(String[] args) {
        Scanner s = new Scanner("this   is a  \n\tTest");
        s.useDelimiter("\\b");
        while (s.hasNext()) {
            String token = s.next();
            System.out.println("\"" + StringEscapeUtils.escapeJava(token)
                    + "\"\tapply shiftToken = " + !token.matches("\\A\\s+\\z"));
        }
    }
}