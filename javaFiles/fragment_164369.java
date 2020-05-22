public class PayloadValidatingInterceptor extends PayloadValidatingInterceptor {

    private ResourceLoader resourceLoader;

    private static final Logger LOGGER = Logger.getLogger(this.getClass());

    @Override
    protected final Source getValidationRequestSource(WebServiceMessage webServiceMessage_) {
        Source _source = null;
        try {
            _source = webServiceMessage_.getPayloadSource();
            validateSchema(_source);
          } catch (SoapFaultClientException _soapException) {
              LOGGER.error("SOAP Fault " + _soapException.getMessage(), _soapException);              
          } catch (Exception _exception) {
              LOGGER.error("Exception " + _exception.getMessage(), _exception);
          }

      return _source;  
    }

    private String getNamespace(final Source source_) {
        DOMSource _currentdomSource = (DOMSource) source_;
        Node _currentNode = _currentdomSource.getNode();

        if (_currentNode != null) {
            String _currentNamespaceUri = _currentNode.getNamespaceURI();

            // do whatever you need to identifiy your namespace

            } else {
                logger.warn("the namespace is not recognized: " + _currentNamespaceUri);
            }
         } else {
             logger.warn("The current namespace could not be determined");
         }

        return null;
    }


    private void validateSchema(Source source_) throws IOException, SAXException {
        final String _namespace = getNamespace(source_);

        if (_namespace != null) {
            SchemaFactory _schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema _schema = null;

            // based on the identified namespace you can choose the appropriate xsd
            // for example : _schema = _schemaFactory.newSchema(getSchemas()[0].getFile()); 

            Validator _validator = _schema.newValidator();
            DOMResult _result = new DOMResult();
            try {
                _validator.validate(source_, _result); 
            } catch (SAXException _exception) {
                setFaultStringOrReason(GENERIC_ERROR_MESSAGE + " : " + _exception.getLocalizedMessage());               
            }
        } else {
            setFaultStringOrReason(NAMESPACE_ERROR_MESSAGE);
        }
    }

    public final ResourceLoader getResourceLoader() {
        return resourceLoader;
    }

    public final void setResourceLoader(ResourceLoader resourceLoader_) {
        this.resourceLoader = resourceLoader_;
    }

}