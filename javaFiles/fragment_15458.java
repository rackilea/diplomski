XPathExpression expr = xpath.compile("//Country/Group/C");
...
for (int i = 0; i < nodes.getLength(); i++) 
{
    node = nodes.item(i);
    out.write(" " + node.getTextContent() + "\n");
}