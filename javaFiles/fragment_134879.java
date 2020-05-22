String s = "This is some sample text and has to be splited properly";
    Pattern splitPattern = Pattern.compile("(.{1,15})\\b( |$)");
    Matcher m = splitPattern.matcher(s);
    List<String> stringList = new ArrayList<String>();
    while (m.find()) {
        stringList.add(m.group(1));
    }