public class Test {
    public static void main(String[] args) throws IOException {
        String      text = "int a = 100;\n" +
                "float b = 100.10;\n" +
                "double c - 12.454545645;\n" +
                "long longest dsfsf = 453543543543;\n" +
                "a = d;\n" +
                "char     b = 'a';\n" +
                "String str = \"dfssffdsdfsd\"\n" +
                "int d,f,g;\n" +
                "int a,f,frhg = 0;\n" +
                "String string = \"a,b,c,d,e,f\"";

        Pattern pattern = Pattern.compile("(?:(?<=int|float|String|double|char|long)(?:\\s+)([a-zA-Z_$][\\w$]*)(?:\\s*)|(?<=\\G,)(?:\\s*)([a-zA-Z_$][\\w$]*)(?:\\s*))(?=,|;|=)");
        Matcher matcher = pattern.matcher(text);
        while(matcher.find()){
            System.out.println("trim(): " + text.substring(matcher.start(),matcher.end()).trim()); // cut off spaces by trim() method;

            int group = (matcher.group(1)==null)? 2 : 1; // check which group captured string;
            System.out.println("group(" + group + "): \n\t"  // to extract string by group capturing;
                    + text.substring(matcher.start(group),matcher.end(group))
                    + ",\n\tsubstring(" + matcher.start(group) + "," + matcher.end(group)+")");

        }
    }
}