Document doc = ...

for( Element element : doc.select("div.XYZ") )
{
    element.remove();
}