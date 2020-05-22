Matcher m = Pattern.compile("(?<=/image)\\d{3}").matcher(str);
    StringBuffer sb = new StringBuffer();
    while(m.find()) {
        m.appendReplacement(sb, String.format("%03d", Integer.parseInt(m.group()) - 1));
    }
    m.appendTail(sb);