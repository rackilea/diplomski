@Override
public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
  if (!HALResponse.class.isAssignableFrom(type)) {
    return null;
  }
  // TODO create converter with `type` now that you know what it is...
}