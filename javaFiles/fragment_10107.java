class S {
   S() {
      // Format user's hard drive, call 911, and initiate self-destruct
   }
}

class T {
   T(S s) {} // Now T "has an S" instead of "is an S"
}

class Test {
   @Mock private S mockS;
   new T(s); // T's call to super() should call the mock, not the destructive S.
}