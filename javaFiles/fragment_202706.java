String string  = "Master_${field1}_${field2}_End";
Map<String, String> toBeInserted = new HashMap<String, String>();
toBeInserted.put("field1", "slave1");
toBeInserted.put("field2", "slave2");
toBeInserted.put("field3", "slave3");

Pattern p = Pattern.compile("\\$\\{(.+?)\\}");
Matcher m = p.matcher(string);
StringBuffer sb = new StringBuffer();
while (m.find()) {
    String key = m.group(1);
    if (key != null) {
        String value =  toBeInserted.get(key);
        if (value != null)
            m.appendReplacement(sb, value);
    }
}
m.appendTail(sb);
System.out.println(sb.toString());