for (Iterator it = c.iterator();; ) {
        if (!it.hasNext()) {
           break;
        }
        System.out.println(it.next());
    }
    System.out.println("Out");