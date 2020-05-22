class A implements Comparable<A> { ... }

class B extends A { }

List<B> bList = ...;
B bMax = max(bList);