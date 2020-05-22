Document doc = // ... eg. parse File / String here or connect to a website
Node value;

for( Element element : doc.select("strong ~ *") )
{
    // element.previousSibling() is possible too
    value = element.nextSibling();
    System.out.println(value);
}