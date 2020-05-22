Document document = Jsoup.connect(url).get();
Element articleHeader = document.select("#articleHeader").first();
String headline = articleHeader.select(".headline").text();
String subheadline = articleHeader.select(".subheadline").text();
String us_details = articleHeader.select(".us_details").text();
// ...