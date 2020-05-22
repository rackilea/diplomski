Map < Object, Integer > resultMap =
    testSet.parallelStream()
    .collect(Collectors.groupingBy(item - > {
            if (item.getId().equals(hazelcastInstance.getMap("idMap").get(id)) 
                    return "inclusive";
                else
                    return "exclusive";
            },
            Collectors.summingInt(CustomObject::getQty)));