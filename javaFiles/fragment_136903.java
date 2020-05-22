// code as written above
    Pattern pattern = Pattern.compile(";jsessionid(=\\w+)");
    Matcher m = pattern.matcher(content);

    content = m.replaceAll("");

    Files.write(content, html, Charsets.UTF_8);