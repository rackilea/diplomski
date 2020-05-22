Class2 c22 = List.of(c1).stream().map(i1 -> {
        Class2 i2 = new Class2();
        i2.setX(i1.getX());
        i2.setY(i1.getY());
        i2.setDatas(i1.getDatas().stream().map(c3 -> {
            Class4 c4 = new Class4();
            c4.setX(c3.getX());
            c4.setY(c3.getY());
            return c4;
        }).collect(Collectors.toSet()));
        return i2;
}).collect(Collectors.toList()).get(0);
System.out.println(c22);