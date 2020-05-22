static String getReplacement(String in) {
    if(in.contains(".")) {
        StringBuilder result = new StringBuilder();

        String[] parts = in.split("\\.");

        for(int i = 0; i < parts.length; ++i) {
            if(i > 0) {
                result.append(".");
            }

            String part = parts[i];

            if(i == 0 || !exclude.contains(parts[i - 1])) {
                part = getReplacement(part);
            }

            result.append(part);
        }

        return result.toString();
    }

    StringBuffer b = new StringBuffer();
    Matcher m = Pattern.compile("_(.)").matcher(in);
    while(m.find()) {
        m.appendReplacement(b, m.group(1).toUpperCase());
    }

    m.appendTail(b);
    return b.toString();
}