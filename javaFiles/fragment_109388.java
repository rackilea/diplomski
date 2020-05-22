Animal cat = new Cat();
    Animal dog = new Dog();

    cat.getType().getWriter().write(cat);

    // java.lang.ClassCastException in the write() method's argument
    cat.getType().getWriter().write(dog);