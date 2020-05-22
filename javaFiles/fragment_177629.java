Document doc = null;
try {
    doc = Jsoup.connect("https://www.stormshield.one/pve/stats/daviddean/sch").get();
} catch (IOException e) {
    e.printStackTrace();
}

Element table = doc.body().getElementsByTag("table").first();

Element thead = table.getElementsByTag("thead").first();

StringBuilder headBuilder = new StringBuilder();

for (Element th : thead.getElementsByTag("th")) {
    headBuilder.append(th.text());
    headBuilder.append(" ");
}

System.out.println(headBuilder.toString());

Element tbody = table.getElementsByTag("tbody").first();

for (Element tr : tbody.getElementsByTag("tr")) {
    StringBuilder rowBuilder = new StringBuilder();

    for (Element td : tr.getElementsByTag("td")) {
        rowBuilder.append(td.text());
        rowBuilder.append(" ");
    }
    System.out.println(rowBuilder.toString());
}