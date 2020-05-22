final String html = "<th style=\"text-align:right\">4389</th>";

Document doc = Jsoup.parse(html, "", Parser.xmlParser()); // Using the default html parser may remove the style attribute
Element th = doc.select("th[style]").first();


String style = th.attr("style"); // You can put those two lines into one
String styleValue = style.split(":")[1]; // TODO: Insert a check if a value is set

// Output the results
System.out.println(th);
System.out.println(style);
System.out.println(styleValue);