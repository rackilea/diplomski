public boolean isUserDefined(Class o) {
  if (o.isAssignableFrom(String.class)) {
    return false;
  }
  if (o.isAssignableFrom(Double.class)) {
    return false;
  }
  if (o.isAssignableFrom(Integer.class)) {
    return false;
  }
  if (o.isAssignableFrom(Boolean.class)) {
    return false;
  }
  if (o.isAssignableFrom(Short.class)) {
    return false;
  }
  if (o.isAssignableFrom(Float.class)) {
    return false;
  }
  if (o.isAssignableFrom(Long.class)) {
    return false;
  }
  return true;
}