Set<String> set = new HashSet<String>();
    set.add("This is Tiger");
    set.add("This is Cat");
    set.add("This is Dog");
    set.add("This is Elephant");
    set.add("This is Parrot");

    /*
      This is Elephant
      This is Parrot
      This is Cat
      This is Dog
      This is Tiger
     */
    for (String str : set) {
        System.out.println(str);

    }