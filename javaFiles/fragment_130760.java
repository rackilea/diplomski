public void putMappingFromString(String index, String type, String mapping) {

    IndicesAdminClient iac = getClient().admin().indices();
    PutMappingRequestBuilder pmrb = new PutMappingRequestBuilder(iac);
    pmrb.setIndices(index);
    pmrb.setType(type);
    pmrb.setSource(mapping);
    ListenableActionFuture<PutMappingResponse> laf = pmrb.execute();
    PutMappingResponse pmr = laf.actionGet();
    pmr.getAcknowledged();

}