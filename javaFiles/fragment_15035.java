for (API api: apilist) {
  MyMethodCallbackHandler handler = new MyMethodCallbackHandler();
  api.send(...., handler);
  try {
    Object result = handler.get();
    .. do more success stuff
  } catch (Throwable ex) {
    // handle problems
  }
}