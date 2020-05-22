function classImport() {
  var location = new java.net.URL('file:/C:/foo/bin/');
  var urlArray = java.lang.reflect.Array.newInstance(java.net.URL, 1);
  urlArray[0] = location;
  var classLoader = new java.net.URLClassLoader(urlArray);
  return classLoader.loadClass("HelloWorld");
}

var myClass = classImport();

for(var i=0; i<10; i++) {
  myClass.getConstructor(null).newInstance(null).say();
}