BrokenGenerics<A> aBreaker = new BrokenGenerics<A>(new A("1"));
A[] array = aBreaker.getArray();
System.out.println(array[0]);
System.out.println(aBreaker.getType());
breakThis(aBreaker);
array = aBreaker.getArray(); // ClassCastException here!
System.out.println(array[0]);
System.out.println(aBreaker.getType());