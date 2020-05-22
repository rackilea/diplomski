String teststr = "{\"Place\": \"DENMARK\", \"ID\": \"9513436\", \"trains_used\": 3, \"Current\": \"_ ___ ____\"}";

String regex = ".*?: \"(.*?)\".*?: \"(.*?)\".*?: (.*?),.*?: (\".*?\")";
Pattern p = Pattern.compile(regex);
Matcher m = p.matcher(teststr);

if (m.find()) {
    System.out.println(m.group(1) + " " + m.group(2) + " " + m.group(3) + " " + m.group(4));
}