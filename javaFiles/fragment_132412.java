Document document = Jsoup.parse(html);

Elements dts = document.getElementsByClass("dt dlterm");
Elements dds = document.getElementsByClass("dd");

if (dts.size() != dds.size()) {
    // ensure same sizes of both lists
}

HashMap<String, String> values = new HashMap<>();
for (int i = 0; i < dts.size(); i++) {
    values.put(dts.get(i).text(), dds.get(i).text());
}