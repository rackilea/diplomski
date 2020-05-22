Set<Class4> list3ToList4ThenSet = list1.stream().map(c3 -> {
    Class4 c4 = new Class4();
    c4.setX(c3.getX());
    c4.setY(c3.getY());
    return c4;
}).collect(Collectors.toSet());
Set<Class4> list3ToSetThen4 = new HashSet<Class3>(list1).stream().map(c3 -> {
    Class4 c4 = new Class4();
    c4.setX(c3.getX());
    c4.setY(c3.getY());
    return c4;
}).collect(Collectors.toSet());