Document excel = Jsoup.parse(tab);

for (Element row : excel.select("table.chart>tbody>tr")) {
    Elements tds = row.select("td");
    int count = 0;

    Element junkTd = row.select("td table td").first();

    for (Element element : tds) {
        if(!element.text().isEmpty() 
                && element.children().isEmpty()
                && !element.equals(junkTd)){

            count++;
            System.out.println("line "+count+" text = '"+element.text()+"'");
        }
    }
}