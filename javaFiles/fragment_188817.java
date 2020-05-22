@Override
public Converter<ResponseBody, ?> fromResponseBody(Type type, Annotation[] annotations) {
  if (!this.type.equals(type)) {
    return null;
  }
  return new HALResponseBodyConverter<>(gson);
}