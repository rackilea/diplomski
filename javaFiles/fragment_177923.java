for (NamingEnumeration<Vector> ne : list) {
    while (ne.hasMore()) {
        Vector vector = ne.next();
        for (Object object : vector) {
            System.out.println(object);
        }
    }
}