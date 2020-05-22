for (final ArrayPatternConverter converter : patternConverters) {
    if (converter instanceof DatePatternConverter) {
        final DatePatternConverter dateConverter = (DatePatternConverter) converter;
        frequency = calculateFrequency(dateConverter.getPattern());
    }
}