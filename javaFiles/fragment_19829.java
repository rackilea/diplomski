// Place the root element of theXML into a variable
List<? extends Node> items =
        (List<? extends Node>)theXML.selectNodes("//rss/channel/item");

// RFC-dictated date format used with RSS
DateFormat dateFormatterRssPubDate =
        new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);

// today started at this time
DateTime timeTodayStartedAt = new DateTime().withTimeAtStartOfDay();

for (Node node: items) {
     String pubDate = node.valueOf( "pubDate" );
     DateTime date = new DateTime(dateFormatterRssPubDate.parse(pubDate));
     if (date.isAfter(timeTodayStartedAt)) {
         // it's today, do something!
         System.out.println("Today: " + date);
     } else {
         System.out.println("Not today: " + date);
     }
}