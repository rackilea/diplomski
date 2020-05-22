Object bean;
String property;
Method getter;
// ...

try {
    getter.invoke(bean);
} catch (Exception e) {
    String message = String.format("Error reading '%s' on type %s", property, bean.getClass().getName());
    throw new ELException(message, e);
}