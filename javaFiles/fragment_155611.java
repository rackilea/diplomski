@Override
public boolean handleFault(MessageContext messageContext) throws WebServiceClientException {
    LOGGER.debug("intercepted a fault.");
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    WebServiceMessage response = messageContext.getResponse();
    Source source = response.getPayloadSource();
    StreamResult streamResult = new StreamResult(new StringWriter());

    try {
        Transformer displayTransformer = transformerFactory.newTransformer();
        displayTransformer.transform(source, streamResult);
        LOGGER.debug("\t>> initial response\n" + streamResult.getWriter().toString());

        StreamSource xslSource = new StreamSource(new File(
                FaultInterceptor.class.getResource("/SoapFaultFix.xsl").getFile()
        ));
        Transformer modifyingTransformer = transformerFactory.newTransformer(xslSource);
        modifyingTransformer.transform(source, response.getPayloadResult());

    } catch (TransformerException e) {
        e.printStackTrace();
    }

    return true;
}