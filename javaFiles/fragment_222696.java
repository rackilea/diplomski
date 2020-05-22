String xml1 = "<a>a</a>";
String xml2 = "<a>1</a>";
assertTrue(compareXMLs(xml1, xml2));

xml1 = "<a></a>";
xml2 = "<a>1</a>";
assertTrue(compareXMLs(xml1, xml2));

xml1 = "<a></a>";
xml2 = "<a><f></f></a>";
assertFalse(compareXMLs(xml1, xml2));