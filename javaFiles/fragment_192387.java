int hits=0;
Bar cache=foo.read();  // Foo.bar is volatile
while(/*...*/) {
  if(++hits==100) {
    hits=0;
    cache=foo.read();
  }
  cache.doStuff();
}