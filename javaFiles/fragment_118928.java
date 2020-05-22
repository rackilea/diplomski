String rawXMLQuery =
  "<q:qbe xmlns:q='http://marklogic.com/appservices/querybyexample'>"+
    "<q:query>" +
      "<emailAddress>vikram@gmail.com</emailAddress>" +
    "</q:query>" +
  "</q:qbe>";
StringHandle rawHandle = 
    new StringHandle(rawXMLQuery).withFormat(Format.XML);
RawQueryByExampleDefinition query =
    queryMgr.newRawQueryByExampleDefinition(rawHandle);