public static HashMap<String, String> keyVal;

static {
    keyVal = new HashMap<String, String>();
    keyVal.put("<mft:A>", "<font color=\\red\">");
    keyVal.put("<mft:S>", "<font color=\\green\">");
    keyVal.put("<mft:R>", "<font color=\\blue\">");
    keyVal.put("</mft:A>", "</font>");
    keyVal.put("</mft:S>", "</font>");
    keyVal.put("</mft:R>", "</font>");
}

public String replaceTag(String replace) {
    for(String key:keyVal.keySet())
        replace=replace.replaceAll(key,keyVal.get(key));
    return replace;
}