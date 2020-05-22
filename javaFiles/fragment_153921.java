URL url = new URL("http://www.myurl.com");
Document doc = Jsoup.parse(url, 3000);
// This should work now
Element tables = doc.select("table tr .id");
// This propably should work too
Element tables2 = doc.select("table tr[class*=id]");

for(Element table : tables)
{
     System.out.println(table.toString());
}