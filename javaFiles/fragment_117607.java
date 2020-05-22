ArrayList<Order> d = new ArrayList<>();
    d.add(new Order("Stack", "Overflow"));
    d.add(new Order("Ask", "Ubuntu"));
    d.add(new Order("Super", "User"));

    for (Order o : d) {
        if (o.getName().equals("Super") && o.getVal().equals("User")) {
            System.out.println("index of Super User: " + d.indexOf(o));
        }
    }