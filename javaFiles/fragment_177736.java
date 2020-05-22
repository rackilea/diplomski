@Override
protected void populateUserDefinedHeader(String headerName, Object headerValue, SoapMessage target) {
    super.populateUserDefinedHeader(headerName, headerValue, target);

    TransportContext context = TransportContextHolder.getTransportContext();
    HttpUrlConnection connection = (HttpUrlConnection) context.getConnection();

    connection.getConnection().addRequestProperty(headerName, headerValue);
}