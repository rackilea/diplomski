Map<String,Map<String,Integer>> map = 
    list.stream()
        .collect(Collectors.
                    groupingBy(MyObject::getX,
                               Collectors.groupingBy(MyObject::getY,
                                                     Collectors.summingInt(MyObject::getZ))));