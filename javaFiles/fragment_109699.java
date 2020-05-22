Function<String, String> extractAnnotationAndTextWithinParentheses = s -> {
        Matcher m = pattern.matcher(s);
        m.find();
        StringBuilder sb = new StringBuilder();
        int lastGroup = m.groupCount();
        for (int i = 1; i <= lastGroup; i++) {
            sb.append(m.group(i));
            if (i < lastGroup) sb.append("\t");
        }
        return sb.toString();
};