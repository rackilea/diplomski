StringBuilder message = new  StringBuilder("abc[11]xyz[86]pqr[87]sdv[11]adf[86]fgr[87]fadggthy");
    Map<String, String> replaceStringMap = new HashMap();
    replaceStringMap.put("\\[11\\]", "11");
    replaceStringMap.put("\\[86\\]", "86");
    replaceStringMap.put("\\[87\\]", "87");
    String starter = "(";
    String middle = ")|(";
    String end = ")";
    Set<String> keySet = replaceStringMap.keySet();
    boolean isFirst = true;
    StringBuilder regex = new StringBuilder(starter);
    Iterator<String> itr = keySet.iterator();
    while (itr.hasNext()) {
        String string = itr.next();
        if (itr.hasNext()) {
            regex.append(string);
            regex.append(middle);
        } else {
            regex.append(string);
            regex.append(end);
        }
    }
    System.out.println(regex.toString());
    String[] strings = message.toString().split(regex.toString());
    for (String s : strings) {
        System.out.println(s);
    }
}