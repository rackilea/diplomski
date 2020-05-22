void call(StringObject x) {
    x = new StringObject("baz"); // this creates a new address in x!
}

StringObject i = new StringObject("foo"); // remember, i is only an address!
                                          // the address is '3'
                                          // the actual value can be looked up
                                          // in our memory table above
                                          // '3' -> 'foo'

call(i);
System.out.println(i);