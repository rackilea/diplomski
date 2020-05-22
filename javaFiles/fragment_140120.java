String str = "####title###title";  // str is the method parameter
    if (str.equals("# "))
        System.out.println(" ");

    Pattern pattern = Pattern.compile("(#+[^#]+)");
    Matcher matcher = pattern.matcher(str);

    while (matcher.find()) {
        String str1 = matcher.group(1);
        int n = str1.length() - str1.replaceFirst("#+", "").length();
        System.out.println("<h" + n + ">" + str1.substring(n) + "</h" + n + ">");
    }