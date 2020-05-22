private Response<String> getStringResponse(Request<?> request,
      AmazonHttpClient client,
      ExecutionContext executionContext,
      HttpResponseHandler<AmazonClientException> handler,
      HttpResponseHandler<String> responseHandler) {
    try {
      RequestExecutionBuilder requestExecutionBuilder = client.requestExecutionBuilder()
          .executionContext(executionContext)
          .request(request)
          .errorResponseHandler(handler);
      Response<String> response = requestExecutionBuilder.execute(responseHandler);
      return response;
    } catch (Exception e) {
      AppLogger.getLogger().error("Exception in :: classname :: getStringResponse() ::");
      throw e;
    }
  }