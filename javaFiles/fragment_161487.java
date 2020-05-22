public class Test {
    public static void main(String[] args) {
        String[] expressions = {"2!+atan2(3+9,2+3)-2*PI+3/3-9-12%3*sin(9-9)+(2+6/2)", "2+3-9*[{2+3,2,6},{7,2+3,2+3i}]+9*6",
        "{[2,5][9/8,func(2+3)]}+9*8/5","<[2,9,2.36][2,3,2!]>*<[2,3,9][23 + 9 * 8 / 8, 2, 3]>"};
        Pattern pattern = Pattern.compile("(?<matrix>(?:\\[[^]]+])|(?:<[^>]+>)|(?:\\{[^}]+}))|(?<function>\\w+(?=\\())|(?<operand>\\w+)|(?<operator>[-+/*%])|(?<symbol>.)");
        for(String expression : expressions) {
            List<String> elements = new ArrayList<String>();
            Matcher matcher = pattern.matcher(expression);
            while (matcher.find()) {
                elements.add(matcher.group());
            }
            for (String element : elements) {
                System.out.println(element);
            }
            System.out.println("\n\n\n");
        }
    }
}