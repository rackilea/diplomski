int foo = 0;
boolean isFooSet = false;
...
// thread 1
foo = 42;
isFooSet = true;
...
// thread 2
while (!isFooSet) {/*waste some time*/} // we wait until the flag is set in the other thread
System.out.println(42/foo); //we can actually divide by zero here