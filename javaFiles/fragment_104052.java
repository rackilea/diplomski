private static String extractField(String strt, int fieldNo)
{
    Pattern pattern = Pattern.compile("(?<=(^|\\|))(.*?)(?=(\\||$))");
    String str = strt.replaceAll("\\r", "");
    Matcher matcher = pattern.matcher(str);
    int i = 1;
    while (matcher.find()) {
        String fS = matcher.group().trim();
        System.out.println("Result: \"" + fS + "\"");
        if (i++==fieldNo) {
            return fS;
        }
    }
    return "";
}