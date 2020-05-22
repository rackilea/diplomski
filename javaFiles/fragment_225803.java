Connection.Response response = Jsoup.connect("https://rrtp.comed.com/rrtp/ServletFeed?type=pricingtabledual&date=20150717").execute();
Document doc = Jsoup.parse("<table>" + response.body() + "</table>");

for (Element element : doc.select("tr")) {
    System.out.println(element.html());
}