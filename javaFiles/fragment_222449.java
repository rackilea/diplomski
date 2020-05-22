@Override public void handleResponses(ResponseBuilder rb, ShardRequest sreq) {
   ...
   if (stage == MY_STAGE) {
      List<ShardResponse> responses = sreq.responses;
      for (ShardResponse response : responses) {
         //do something with the response, maybe save it somewhere
         rb.finished.remove(sreq);
      }
   }
   ...
}