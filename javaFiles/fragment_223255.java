String input = "Hi ${name}, There's been ${days} days since you logged in on ${site}.";
    String regex = "\\$\\{([^}]+)\\}";

    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    while (matcher.find()) {
        String name = matcher.group(1);
        // name contains now the property name
        // add the logic here: replace occurrences of "${" + name + "}" by the real value
    }