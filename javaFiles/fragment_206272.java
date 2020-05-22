Pattern p = Pattern.compile("\\((.*?)\\)");

    Matcher m = p.matcher("abc (one) abc (two) abc");

    List<String> result = new ArrayList<String>();

    while(m.find())
        result.add(m.group(1));