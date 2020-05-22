// statically linking would be
return component.getText();

// dynamically is
try {
  return (String)component.getClass().getMethod("getText", new Class [] {}).invoke(component, new Object [] {});
} catch (Throwable e) {
  e.printStackTrace();
}