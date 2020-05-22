String url = request.getParameter("htmluri").trim();
System.out.println("Fetching %s..."+url);

Document doc = Jsoup.connect(url).get();
Document.OutputSettings settings = doc.outputSettings();
settings.prettyPrint(false);
settings.charset("ASCII");
String html = doc.html();
html = StringEscapeUtils.unescapeHtml(html);
html = Jsoup.parse(html).html();   //This will take care of any extra closing tags 
System.out.println(html);