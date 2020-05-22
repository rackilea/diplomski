List<String> parts = new ArrayList<String>();

    String input = "+2+ sqrt(25 )-41*3- abs(-4)-62 /2";
    Pattern p = Pattern.compile("[\\+\\-/\\*][^\\+\\-\\*/\\(]+(\\([^\\(\\)]*\\))?");

    Matcher m = p.matcher(input);
    while (m.find()) {
        parts.add(m.group());
    }