String str = "key1=valueforkey1==&key2=valueforkey2";
Pattern p = Pattern.compile("([^=&\\s]+)=(.*?)(?=&[^=&\\s]+=|$)");
Matcher m = p.matcher(str);
Map<String, String> res = new HashMap<String, String>();
while (m.find()) {
    res.put(m.group(1), m.group(2));
}
System.out.println(res); // => {key1=valueforkey1==, key2=valueforkey2}