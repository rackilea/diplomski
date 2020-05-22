String source = "<tag>              </tag>          <b>hello</b>      <tag>       orange  gsdggg  </tag>  <tag>p wfwfw   ear</tag>";

Document doc = Jsoup.parse(source);
Elements elements = doc.select("tag:matches(\\S)");//finds <tag> which text contains at least one non-whitespace character

System.out.println("Total occurance is -" + elements.size());
for (Element el: elements){
    System.out.println(el.text());
}