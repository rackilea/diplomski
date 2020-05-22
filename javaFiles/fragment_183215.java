s1 == s1;         // true, same pointer
s1 == s2;         // true, s1 and s1 share storage in common pool
s1 == s3;         // true, s3 is assigned same pointer as s1
s1.equals(s3);    // true, same contents
s1 == s4;         // false, different pointers
s1.equals(s4);    // true, same contents
s4 == s5;         // false, different pointers in heap
s4.equals(s5);    // true, same contents