Function<List<Class3>, Set<Class4>> convertClassesAndToSet = l -> l.stream().map(c3 -> {
        Class4 c4 = new Class4();
        c4.setX(c3.getX());
        c4.setY(c3.getY());
        return c4;
    }).collect(Collectors.toSet());
Function<List<Class3>, Set<Class4>> toSetAndConvertClasses = l -> new HashSet<>(l).stream().map(c3 -> {
        Class4 c4 = new Class4();
        c4.setX(c3.getX());
        c4.setY(c3.getY());
        return c4;
}).collect(Collectors.toSet());