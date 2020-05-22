XmlTextReader reader = new XmlTextReader(URL);

XPathDocument doc = new XPathDocument(reader);
XPathNavigator nav = doc.CreateNavigator();

List<string> hourly = new List<string>();

foreach(XPathNavigator node in (XPathNodeIterator) nav.Evaluate("/dwml/data/time-layout[3]/start-valid-time/text()"))
{
    hourly.Add(node.Value);
}