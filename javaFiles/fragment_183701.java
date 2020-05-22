Matcher m = Pattern.compile(".+?:((.+?/)|(.+?$))").matcher(s);
    StringBuffer sb = new StringBuffer();
    while(m.find()) {
        int i = sb.length();
        m.appendReplacement(sb, m.group(1));
        sb.setCharAt(i, Character.toLowerCase(sb.charAt(i)));
    }
    s = sb.toString();