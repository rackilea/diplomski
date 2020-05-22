SomeClass sc1 = new SomeClass();
SomeClass sc2 = sc1;

sc1.setName("Hello");

System.out.println(sc2.getName()); // this will print hello since both sc1 and sc2 are pointing to the same object.