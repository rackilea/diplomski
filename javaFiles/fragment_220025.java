if (object.toString().endsWith("@" + Integer.toHexString(object.hashCode())) {
  // default toString()...
  return ReflectionToStringBuilder.toString(object);
}
else {
  return object.toString();
}