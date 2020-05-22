if (aObj instanceof B.class) {
  B bObj = (B) aObj;
  bObj.method1(); //OK
} else {
  log.debug("This is an A, but not a B");
}
aObj.show();