private String foo = "foo text";
private String bar = "some text";

public String myMethod(String varname) throws Exception {
  Class<?> c = this.getClass();
  Field field = c.getDeclaredField(varname);
  Object fieldValue = field.get(this);
  return fieldValue.toString();
}

// myMethod("foo") returns "foo text"
// myMethod("bar") returns "some text"