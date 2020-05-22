String url = "http://localhost:1111/search?id=10&time=3200&type=abc";

Pattern id = Pattern.compile("id=(\\d+)");

Matcher m = id.matcher(url);
if (m.find())
    System.out.println(m.group(1));