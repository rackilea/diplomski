private static org.apache.neethi.Policy getPolicy (java.lang.String policyString) 
{
  java.io.ByteArrayInputStream bais = new java.io.ByteArrayInputStream(policyString.getBytes());
  try 
  {
    StAXOMBuilder builder = new StAXOMBuilder(bais);
    OMElement documentElement = builder.getDocumentElement();
    return org.apache.neethi.PolicyEngine.getPolicy(documentElement);
  } 
  catch (XMLStreamException e) 
  {
    e.printStackTrace();
  }
  return null;
}