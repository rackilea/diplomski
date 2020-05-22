Document doc = Jsoup.parse("This is a <strong>strong</strong> number <date>2013</date>");

String ownText = doc.body().ownText();
String text = doc.body().text();

System.out.println(ownText);
System.out.println(text);