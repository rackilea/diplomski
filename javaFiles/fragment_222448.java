@Override public int distributedProcess(ResponseBuilder rb) {
    ...
    if (rb.stage == MY_STAGE) {
       ShardRequest sreq = new ShardRequest();
       sreq.purpose = ShardRequest.PURPOSE_PRIVATE;
       sreq.params = new ModifiableSolrParams();
       // set the parameters for the shard request
       rb.addRequest(this, sreq);
    }
    ...
}