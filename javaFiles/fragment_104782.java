factory.addConnectorCustomizers(new TomcatConnectorCustomizer() {
        @Override
        public void customize(Connector connector) {
            ((AbstractProtocol) connector.getProtocolHandler()).setConnectionTimeout(10000);
        }
    });