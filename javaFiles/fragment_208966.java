public class BACENGQueryXMLbyVTD 
{
  private byte[] doc;


  public BACENGQueryXMLbyVTD(byte[] doc) 
  {
    this.doc = doc;
  }

  public List<String> query(String query) throws IOException, VTDException 
  {
    VTDGen generator = new VTDGen();
    generator.setDoc(doc);
    generator.parse(false);

    VTDNav navigator = generator.getNav();

    AutoPilot autoPilot = new AutoPilot(navigator);
    autoPilot.selectXPath(query);

    List<String> nodeInterfaces = new ArrayList<String>();

    int i;
    while ((i = autoPilot.evalXPath()) != -1) 
    {
      navigator.push();
      nodeInterfaces.add(navigator.toString(i + 1));
    }

    return nodeInterfaces;
  }
}