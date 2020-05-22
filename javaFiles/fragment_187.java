List<Integer> list = new ArrayList<Integer>();
    for (int n: num) {
       if (n < x) {
          list.add(n);
       }
    }
    System.out.println("Numbers below " + x + ": " + list);