A someA = new A();

// a is initialised as an A

B aWithExtraProperties = new B(someA);

// now you have a B which has the same values as the original A plus
// b's properties
// and as B subclasses A, you can use it in place of the original A