public class RegexExample {

    /**
     * @param args
     */
    public static void main(String[] args) {

        String href= "<a href=\"w3schools.com\">Visit W3Schools.com!</a>";
        String regexOr = "(?<=[>])(\\\\?.)*?(?=[<])";
        Pattern pattern = Pattern.compile(regexOr);
        Matcher matcher = pattern.matcher(href);
        if (matcher.find()) {
            String enrichedValue = matcher.group();
            System.out.print(enrichedValue);
        }
    }
}