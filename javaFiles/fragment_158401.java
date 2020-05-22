public void testFoo() {
  beginAt("blabla");
  ...
  setScriptingEnabled(false);
  ...//Problematic code
  setScriptingEnabled(true);
  ...
}