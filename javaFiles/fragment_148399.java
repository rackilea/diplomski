MbElement root = outMessage.getRootElement();
MbElement body = root.createElementAsLastChild( MbXMLNSC.PARSER_NAME);  
MbElement itemMaintance = body.createElementAsLastChild( MbElement.TYPE_NAME, "ItemMaintance", null);

MbElement item = itemMaintance.createElementAsLastChild( MbElement.TYPE_NAME, "Item", null);
MbElement action = item.createElementAsLastChild( MbXMLNSC.ATTRIBUTE, "Action", "ACTION");
MbElement serialNumberFlag = item.createElementAsLastChild( MbXMLNSC.ATTRIBUTE, "serialNumberFlag", "0123456789");