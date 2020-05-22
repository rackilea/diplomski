public static void main(String[] args) {
    // first we want to create the lists

    // create list a
    List<String> a = new ArrayList<String>();
    // add members to a
    a.add("2");
    a.add("14");
    // create list b
    List<String> b = new ArrayList<String>();
    // add members to b
    b.add("2");
    b.add("3");
    b.add("4");
    b.add("5");

    // create a list in which we store the "filtered" list - duplicated from
    // a
    List<String> aMinusB = new ArrayList<>(a);
    // "filter" using "removeAll" and giving the list b as the argument
    aMinusB.removeAll(b);
    System.out.println("A minus b:");
    // this is short for
    // "iterate over the entire list, naming the currently iterated node s"
    for (String s : aMinusB) {
        System.out.println(s);
    }

    // duplicate list b in the same manner as above
    List<String> bMinusA = new ArrayList<>(b);
    // "filter" using "removeAll" and giving the list a as the argument in
    // the same manner as above
    bMinusA.removeAll(a);
    System.out.println("B minus a:");
    // this is short for
    // "iterate over the entire list, naming the currently iterated node s"
    // in the same manner as above
    for (String s : bMinusA) {
        System.out.println(s);
    }

}