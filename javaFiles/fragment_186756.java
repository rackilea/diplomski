Set<String> names = new HashSet<String>();
    for (Cat c : set) { 
        if (names.contains(c.getName())) {
            continue;
        }
        names.add(c.getName());
        c.foo(); //your method here
    }