List<My> myList = new ArrayList<My>();
    for (Object[] row : cr.list()) {
         My m = new My();
         m.setQwerty((String) row[0]);
         // set the rest of the properties
         myList.add(m);
    }