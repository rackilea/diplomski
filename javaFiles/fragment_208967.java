byte[] xmlContent = ... //load the xml from anywhere you like, not just a file as previously.

BACENGQueryXMLbyVTD getNodesInterfaces = new BACENGQueryXMLbyVTD(xmlContent);

for (String nodeName : nodeNames) 
{
  String query = "/import_data/group/node[@name='" + nodeName + "']/interface/@network_value";
  nodeInterfaces = getNodesInterfaces.query(query);
  ...
}