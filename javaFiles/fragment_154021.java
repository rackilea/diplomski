List<? super Number> list1;
    list1 = new ArrayList<Number>();  // ok - inclusive
    list1 = new ArrayList<Object>();  // ok - wildcard accepts the super classes
    list1 = new ArrayList<Integer>(); // compilation error

    List<? extends Number> list2;
    list2 = new ArrayList<Number>();  // ok - inclusive
    list2 = new ArrayList<Object>();  // compilation error
    list2 = new ArrayList<Integer>(); // ok - wildcard accepts the subclasses