public class PropertySubstitutor {
    private static final Pattern VARIABLE_PATTERN = Pattern.compile("\\$\\{(.*?)\\}");

    public static String substitute(String source) {
        Matcher matcher = VARIABLE_PATTERN.matcher(source);
        Properties properties = System.getProperties();
        StringBuffer buffer = new StringBuffer(source.length());
        while (matcher.find()) {
            matcher.appendReplacement(buffer, properties.getProperty(matcher.group(1), ""));
        }
        matcher.appendTail(buffer);
        System.out.println(buffer.toString());
        return buffer.toString();
    }

    private PropertySubstitutor() {}
}