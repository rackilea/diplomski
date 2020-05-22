@WebServiceProvider(
  wsdlLocation = "WEB-INF/wsdl/injector.wsdl"
)
@ServiceMode(value = Service.Mode.PAYLOAD)
public class InjectorService implements Provider<Source> {
  private Unmarshaller unmarshaller;

  @Override
  public Source invoke(Source request) {
    try {
      DOMResult requestDom = new DOMResult();
      Transformer trans = TransformerFactory.newInstance().newTransformer();
      trans.transform(request, requestDom);
      Node requestNode = requestDom.getNode();
      // Get the operation name node.
      Node operationNode = requestNode.getFirstChild();
      // Get the parameter node.
      Node parameterNode = operationNode.getFirstChild();
      // Unmarshal
      JAXBElement<Object> element = unmarshaller.unmarshal(parameterNode, Object.class);
      Object unmarshalled = element.getValue();          

      //  Handling customer object and response ......
    } catch (Exception e) {
      throw new RuntimeException("Endpoint error", e);
    }
  }

  protected Class[] getCustomerClasses() {
    // return customer classes somehow
  }

  @PostConstruct
  public void init() throws Exception {
    JAXBContext jbc = JAXBContext.newInstance(getCustomerClasses());
    unmarshaller = jbc.createUnmarshaller();
  }
}