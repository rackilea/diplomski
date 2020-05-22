Set<String> set2 = new HashSet<String>();
    set.add("This is Tiger");
    set.add("This is Cat");
    set.add("This is Dog");
    set.add("This is Elephant");
    set.add("This is Parrot");
    set.add("This is Giraffe");

    /*
      This is Elephant
      This is Parrot
      This is Cat
      This is Giraffe
      This is Dog
      This is Tiger
     */
    for (String str : set) {
        System.out.println(str);

    }