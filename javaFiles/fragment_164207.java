Document doc = Jsoup.connect("http://metudex.com/mobilepac/browse.php?SEARCH=calculus&kriter=X&Submit=Search").get();

Elements els = doc.select("td:has(span.briefcitDetail)"); //gets every td that has a child span with class briefcitDetail

for(Element el : els) {
    System.out.println("--" + el.text());
}