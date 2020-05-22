public static void main(String[] args) {
    Document doc = Jsoup.parse("<html><body>"+
    "<table>" +
    "  <tbody>" +
    "    <tr><td>1</td></tr>" +
    "    <tr class='header'><td>2</td></tr>" + // class added to simulate ur list
    "    <tr><td>3</td></tr>" +
    "    <tr><td>4</td></tr>" +
    "    <tr class='header'><td>5</td></tr>" + // class added to simulate ur list
    "    <tr><td>6</td></tr>" +
    "  </tbody>" +
    "</table>" +
    "</body></html>");

    Elements headerRows = doc.getElementsByClass("header"); // simulating ur list

    Elements tables = new Elements();
    for (Element headerTR : headerRows) {
        Element tbody = doc.createElement("tbody");
        Element firstSiblingTR = headerTR.nextElementSibling();
        if (firstSiblingTR != null) {
            Element secondSiblingTR = firstSiblingTR.nextElementSibling();
            tbody.appendChild(firstSiblingTR);
            if (secondSiblingTR != null) {
                tbody.appendChild(secondSiblingTR);
            }
        }
        Element table = doc.createElement("table");
        table.appendChild(tbody);
        tables.add(table);
    }
    System.out.println(tables); // print <table> list
}