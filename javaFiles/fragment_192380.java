String EMAIL_PATTERN = "^[a-zA-Z0-9][\\w.-]*[a-zA-Z0-9]@[a-zA-Z0-9][\\w.-]*[a-zA-Z0-9]\\.[a-zA-Z][a-zA-Z.]*[a-zA-Z]$";
    String email = "NAME <firstname_lastname@domain.com>";
    Pattern pattern = Pattern.compile(EMAIL_PATTERN.substring(1, EMAIL_PATTERN.length()-1));
    Matcher matcher = pattern.matcher(email);

    if (matcher.find()) {
        System.out.println(matcher.group());
    }