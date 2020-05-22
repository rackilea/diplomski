public <T> T getDynamicValue(Type t) {
     if (isInt()) {
          return (T) ((Integer) t.getValue());
     } else {
          return (T) t.getName();
     }
}