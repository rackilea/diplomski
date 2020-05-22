@RunWith(PowerMockRunner.class)
@PrepareForTest(DocumentBuilderFactory.class)
public class XmlFileWriterTest {

   @Test(expected = ParserConfigurationException.class)
   public void createCompleteExportXmlWithParseConfigurationException() throws Exception {
      String xmlFilename = "junitExportTestWithParseConfigurationException.xml";
      String content = "any content";
      XmlFileWriter writer = new XmlFileWriter();

      // Mock DocumentBuilderFactory: When method newDocumentBuilder() is called, throws a simulated ParserConfigurationException
      DocumentBuilderFactory mockDocumentBuilderFactory = PowerMockito.mock(DocumentBuilderFactory.class);
      PowerMockito.when(mockDocumentBuilderFactory.newDocumentBuilder()).thenThrow(new ParserConfigurationException("Simulated ex"));

      // Mock DocumentBuilderFactory.newInstance(), when is called, returns your mock instance mockDocumentBuilderFactory
      PowerMockito.mockStatic(DocumentBuilderFactory.class);
      PowerMockito.when(DocumentBuilderFactory.newInstance()).thenReturn(mockDocumentBuilderFactory);

      writer.createCompleteExportXml(xmlFilename, content);
   }