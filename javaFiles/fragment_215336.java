class ErrorHandler implements ServerErrorHandler {

  @Override public void error(Context context, Throwable throwable) throws Exception {
    try {
      Map<String, String> errors = new HashMap<>();

      errors.put("error", throwable.getClass().getCanonicalName());
      errors.put("message", throwable.getMessage());

      Gson gson = new GsonBuilder().serializeNulls().create();

      context.getResponse().status(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()).send(gson.toJson(errors));
      throw throwable;
    } catch (Throwable throwable1) {
      throwable1.printStackTrace();
    }
  }

}