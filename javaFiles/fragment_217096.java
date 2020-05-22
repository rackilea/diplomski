System.out.println(iterator.next()); // prints [1]

    iterator.add(new Integer(2)); // [1, 2, 4]
    iterator.add(new Integer(3)); // [1, 2, 3, 4]

    while (iterator.hasNext())
        System.out.println(iterator.next());