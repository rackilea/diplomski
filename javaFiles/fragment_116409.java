File file = new File("/path/to/file.html");
Document document = Jsoup.parse(file, "UTF-8");
Element something = document.select("input[name=something]").first();
String value = something.val();
System.out.println(value); // abc
// ...