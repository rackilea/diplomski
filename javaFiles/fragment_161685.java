private static final Gson gson = new Gson();

static void checkIsjsonSerializable(Object o, String message)
    throws MissingRequiredValueException {

  JsonElement rootElement = gson.toJsonTree(o);
  if (!rootElement.isJsonArray() && !rootElement.isJsonObject()) {
    throw new MissingRequiredValueException(message);
  }
}