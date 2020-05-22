public String format(String input, String... args) {
    Pattern pattern = Pattern.compile("{{((.*?)*?)}}");
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
        String value = matcher.group(1);
        // TODO: error handling
        int index = Integer.parseInt(value);
        if (index < args.length) {
            input.replace(matcher.group(), args[index]);
        }
    }
}