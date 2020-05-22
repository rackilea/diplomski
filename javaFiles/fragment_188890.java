String html = "<div class=\"content\">\n" +
        "<div name=\"panel-summary\" id=\"summary\">\n" +
        "    <p>\n" +
        "    <strong>A: </strong>*thank you* **I want to retrieve this text**<br>\n" +
        "    <strong>B: </strong>*Bla..bla* *I don't want this text*<br>\n" +
        "    <strong>C: </strong>*what ever text* *I dont want this*                         \n" +
        "        <strong>D: </strong>*anythinh text* *I want this*<br>\n" +
        "        <strong>E: </strong>*Bla..bla* *I don't want this text*t<br>\n" +
        "        <strong>F: </strong>*anythinh text* *I want this*<br>\n" +
        "    </p>\n" +
        "\n" +
        "    <p>I want this</p>";

Document doc = Jsoup.parse(html);
Elements pElements = doc.select("#summary p");
Elements strongElements = pElements.first().select("strong:matchesOwn(A:|D:|F:)");
for (Element strong : strongElements) {
    System.out.println(strong.nextSibling());//get next element, including textual element
}
System.out.println("---");
System.out.println(pElements.get(1).text());//textual content of <p>I want this</p>