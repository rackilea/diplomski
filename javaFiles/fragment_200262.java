static class CustomFn extends DoFn<String, String> {
    // access options from wihtin the ParDo
    ValueProvider<String> orgId;
    public CustomFn(ValueProvider<String> orgId) {
        this.orgId = orgId;
    }

    @ProcessElement
    public void processElement( ProcessContext c ) {
      LOG.info( "Hello? " );
      LOG.info( "ORG ID: " + orgId.get() );
    }
}