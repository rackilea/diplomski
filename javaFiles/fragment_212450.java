private String[] getCharArray(String unicodeStr) {
    Properties p = new Properties();
    p.load(new StringReader("key="+unicodeStr));
    unicodeStr = p.getProperty("key");
    ArrayList<String> list = new ArrayList<>();
    int i = 0;
    while (i < unicodeStr.length()) {
        if (Character.isHighSurrogate(unicodeStr.charAt(i)) &&
            ((i+1) < unicodeStr.length()) &&
            Character.isLowSurrogate(unicodeStr.charAt(i+1)))
        {
            list.add(unicodeStr.substring(i, i+2));
            i += 2;
        }
        else {
            list.add(unicodeStr.substring(i, i+1));
            ++i;
        }
    }
    return list.toArray(new String[list.size()]);
}