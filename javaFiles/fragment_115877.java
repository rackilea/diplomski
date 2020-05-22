MyClass[] result;
if (raw instanceof List<?>) { // array
  result = objectMapper.convertValue(raw, MyClass[].class);
} else { // single object
  result = objectMapper.convertValue(raw, MyClass.class);
}