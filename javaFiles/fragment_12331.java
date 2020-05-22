public static String getLogFormatFromPatternLayout(String patternLayout) {
    String input = OptionConverter.convertSpecialChars(patternLayout);
    List converters = new ArrayList();
    List fields = new ArrayList();
    Map converterRegistry = null;

    PatternParser.parse(input, converters, fields, converterRegistry, PatternParser.getPatternLayoutRules());
    return getFormatFromConverters(converters);
}