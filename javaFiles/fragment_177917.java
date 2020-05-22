package a;
class B{}

package b;
class B{
   a.B objectPackageaB;
   b.B objectPackagebB;
   B objectB; // it is legal , it maps to b.B. but if you import class B from package a, then it would be illegal..   
}