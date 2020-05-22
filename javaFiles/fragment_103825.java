function buildXml(string s) {
    XmlDocument d = new XmlDocument();
    d.AppendChild(d.CreateElement(s));

    StringWriter sw = new StringWriter();
    XmlTextWriter xw = new XmlTextWriter(sw);
    d.WriteTo(xw);
    return sw.ToString();
}

buildXml("Test"); //This will return <Test />