public class RandomNumberGen
{
  public static void main(String[] args)
  {
    RandomNumberGen randomNumberGen = new RandomNumberGen();
    String xml = randomNumberGen.doTheRandomToXml();
    System.out.println("The Original Value");
    System.out.println(xml);
    xml = randomNumberGen.addAnotherRandomNumber(xml);
    System.out.println("Added Another random val ");
    System.out.println(xml);

  }

  public String doTheRandomToXml()
  {
    XMLObj xmlObj = new XMLObj();
    xmlObj.setRandomNumberOne(getRandomNumber());
    xmlObj.setRandomNumberTwo(getRandomNumber());
    xmlObj.setRandomNumberThree(getRandomNumber());

    return toXml(xmlObj);
  }

  public String addAnotherRandomNumber(String xml)
  {
    XMLObj xmlObj = fromXml(xml);
    int numberOne = xmlObj.getRandomNumberOne();
    int numberTwo = xmlObj.getRandomNumberTwo();
    int numberThree = xmlObj.getRandomNumberThree();

    CalculatedValue calculatedValue = new CalculatedValue();
    calculatedValue.setCalculatedValue(numberOne + numberTwo - numberThree);
    calculatedValue.setValue(String.format("%s + %s - %s", numberOne, numberTwo, numberThree));

    xmlObj.setCalculatedValue(calculatedValue);
    return toXml(xmlObj);
  }

  private String toXml(XMLObj obj)
  {
    StringWriter stringWriter = new StringWriter();
    try
    {
      JAXBContext jaxbContext = JAXBContext.newInstance(XMLObj.class);
      Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

      jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
      jaxbMarshaller.marshal(obj, stringWriter);

    }
    catch (JAXBException e)
    {
      e.printStackTrace();
    }
    return stringWriter.toString();
  }

  private XMLObj fromXml(String xml)
  {
    XMLObj xmlObj = null;
    try
    {
      StringReader reader = new StringReader(xml);
      JAXBContext jaxbContext = JAXBContext.newInstance(XMLObj.class);

      Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
      xmlObj = (XMLObj) jaxbUnmarshaller.unmarshal(reader);
    }
    catch (JAXBException e)
    {
      e.printStackTrace();
    }
    return xmlObj;
  }

  private int getRandomNumber()
  {
    int randomInt = 0;
    Random randomGenerator = new Random();
    for (int i = 1; i <= 3; i++)
    {
      randomInt = randomGenerator.nextInt(100);
    }
    return randomInt;
  }
}