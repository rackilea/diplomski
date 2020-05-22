File input = null;
Document doc = null;

try
{
    input = new File("abc.htm");
    doc = Jsoup.parse(input, "UTF-8", "");
}