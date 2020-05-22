private static final String DATA = "<name>stuff<name/>\n" +
        "  <locations>example of text<locations/>\n" +
        "  <storybattles>more text somehow<storybattles/>\n" +
        "  <maincharacter>characters n stuff <maincharacter/>";

private static final List<String> KEYWORDS = Arrays.asList(
        new String[]{"name", "locations"});

private static final String PATTERN = "<%1$s>(.+?)<%1$s/>";

public static void main(String[] args) {

    List<String> strs = new ArrayList<>();
    for (String keyword : KEYWORDS) {
        String tempPattern = String.format(PATTERN, keyword);
        Pattern pattern = Pattern.compile(tempPattern);
        Matcher matcher = pattern.matcher(DATA);

        while(matcher.find()){
            strs.add(matcher.group(1));
        }
    }
}