Document document = Jsoup.connect(urlLink).get();
Elements packagenames = document.select("#mastertableid tr:not(.hiderow) td.packagename");
List<String> pdfList = new ArrayList<String>();

for (Element packagename : packagenames) {
    pdfList.add(packagename.text()); 
}