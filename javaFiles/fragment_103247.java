List<Class2> list2WithMapper = list1.stream().map(l1 -> {
    Class2 c2 = new Class2();
    c2.setX(l1.getX());
    c2.setY(l1.getY());
    c2.setDatas(l1.getDatas().stream().map(c3 -> {
        Class4 c4 = new Class4();
        c4.setX(c3.getX());
        c4.setY(c3.getY());
        return c4;
    }).collect(Collectors.toSet()));
    return c2;
}).collect(Collectors.toList());