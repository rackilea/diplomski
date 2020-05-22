Vector<Vector<Integer>> current_domain = new Vector<Vector<Integer>>();

    Vector<Integer> vect = new Vector<Integer>();
    vect.add(4);
    vect.add(5);

    current_domain.add(vect);
    current_domain.get(0).remove(0);

    System.out.println(current_domain);