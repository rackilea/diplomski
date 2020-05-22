Document doc = Jsoup
                 .connect("http://www.mufap.com.pk/nav_returns_performance.php?tab=01")
                 .get();

for (Element table : doc.getElementsByTag("table")) {
    for (Element trElement : table.getElementsByTag("tr")) {
        // skip header "tr"s and process only data "tr"s
        if (trElement.hasClass("tab-data1")) {

            StringJoiner tdj = new StringJoiner(",");
            for (Element tdElement : trElement.getElementsByTag("td")) {
                tdj.add(tdElement.text());
            }

            System.out.println(tdj);
        }
    }
}