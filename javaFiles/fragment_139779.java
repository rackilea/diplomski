class RemoveActionHandler implements SOAPHandler<SOAPMessageContext> {
    @Override
    public boolean handleMessage(SOAPMessageContext context) {
        if ("".equals(context.get(BindingProvider.SOAPACTION_URI_PROPERTY)))
            context.put(BindingProvider.SOAPACTION_URI_PROPERTY, null);

        return true;
    }

    ...
}