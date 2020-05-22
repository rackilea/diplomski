Myobj *one = new Myobj();
Myobj *two = one;
//one and two are the same thing, pointer's to a Myobj

Myobj one;
Myobj *two = &one;
//one is an object that will be deallocated at end of current scope
//two is a pointer to one