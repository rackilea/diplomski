public static String replaceMany(String input, 
            Map<String, String> replacements) {
        // build a composite pattern for all replacement keys
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (String k : replacements.keySet()) {
            sb.append(prefix).append(Pattern.quote(k));
            prefix = "|";
        }
        Pattern p = Pattern.compile(sb.toString());
        // replace in single loop
        Matcher m = p.matcher(input);
        StringBuffer output = new StringBuffer();
        while (m.find()) {
            // inspired by http://stackoverflow.com/a/948381/15472
            m.appendReplacement(output, "");
            output.append(replacements.get(m.group(0)));
        }
        m.appendTail(output);
        return output.toString();
    }