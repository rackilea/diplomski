private static String replacePlaceHolder(String template, List<String> placeholders, List<String> replacements) {
    for (int i = 0; i < placeholders.size(); i++){
        template = template.replaceFirst(Pattern.quote(placeholders.get(i)),
                                         Matcher.quoteReplacement(replacements.get(i)));
    }
    return template;
}