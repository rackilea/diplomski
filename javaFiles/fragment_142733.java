public class XMLRunner
{

  public static void main(String[] args)
  {
    doFromFile("d:\\myxml.xml");
    doFromString("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
            "    <isomsg direction=\"incoming\">\n" +
            "        <id id=\"2\" value=\"929501003300038807\"/>\n" +
            "        <id id=\"3\" value=\"0301100\"/>\n" +
            "        <id id=\"4\" value=\"000000000000\"/>\n" +
            "   </isomsg>    ");
  }

  public static void doFromFile(String filename)
  {
    try
    {
      System.out.println("About to unmarshal from file : " + filename);
      File file = new File(filename);
      JAXBContext jaxbContext = JAXBContext.newInstance(Isomsg.class);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      Isomsg isomsg = (Isomsg) jaxbUnmarshaller.unmarshal(file);
      System.out.println("You have " + isomsg.getIdList().size() + " items");

      for (XMLObject xmlObject : isomsg.getIdList())
      {
        System.out.println(xmlObject.getValue());
      }
    }
    catch (JAXBException e)
    {
      e.printStackTrace();
    }
  }

  public static void doFromString(String xmlString)
  {
    try
    {
      System.out.println("About to unmarshal from string  : " + xmlString);
      JAXBContext jaxbContext = JAXBContext.newInstance(Isomsg.class);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

      StringReader reader = new StringReader(xmlString);
      Isomsg isomsg = (Isomsg) jaxbUnmarshaller.unmarshal(reader);
      System.out.println("You have " + isomsg.getIdList().size() + " items");

      for (XMLObject xmlObject : isomsg.getIdList())
      {
        System.out.println(xmlObject.getValue());
      }
    }
    catch (JAXBException e)
    {
      e.printStackTrace();
    }
  }

}