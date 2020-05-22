XmlObject inputXml = XmlObject.Factory.parse(xmlFileContent).selectChildren(new QName("MyXml"))[0];
paramMap.put("var1", inputXml);

options.setXqueryVariables(paramMap);

XmlObject[] resultsObjects = xmlObject.execQuery("declare variable $var1 as element() external; <a>{$var1/someValues/MoreNodes}</a>", options);