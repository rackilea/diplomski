public class SchemaErrorHandler implements Processor {

    private final String STATUS_CODE = "6103";

    private final String SEVERITY_CODE = "2";

    @Override
    public void process(Exchange exchange) throws Exception {

        Map<String, Object> map = exchange.getProperties();
        String statusDesc = "Unknown exception";
        if (map != null) {
            SchemaValidationException exception = (SchemaValidationException) map.get("CamelExceptionCaught");
            if (exception != null && !CollectionUtils.isEmpty(exception.getErrors())) {
                StringBuffer buffer = new StringBuffer();
                for (SAXParseException e : exception.getErrors()) {
                    statusDesc = e.getMessage();
                    buffer.append(statusDesc);
                }
                statusDesc = buffer.toString();
            }
        }
        Fault fault = new Fault(new Message(statusDesc, (ResourceBundle) null));
        fault.setDetail(ErrorUtils.createDetailSection(STATUS_CODE, statusDesc, exchange, SEVERITY_CODE));
        throw fault;
    }
}