interface I {}
class A implements I {}
class B implements I {}

List<I> interfaceList = ...;
interfaceList.add(new A());
interfaceList.add(new B());
List<A> aList = interfaceList;  // error! interfaceList contains a B, and a B is not allowed in a list of As