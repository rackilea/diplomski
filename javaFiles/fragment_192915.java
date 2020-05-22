List<Entity> result = entities.stream()
    // group by code and sort the resulting lists by version
    .collect(groupingBy(Entity::getCode, HashMap::new,
            collectingAndThen(toList(), e -> e.stream().sorted(comparingInt(Entity::getVersion).reversed()).collect(toList()))))
    .values()
    .stream()
    // keep only the max values
    .map(l -> l.size() > 0 ? l.stream().filter(i -> i.getVersion() == l.get(0).getVersion()).collect(toList()) : l)
    .flatMap(List::stream)
    .collect(toList());

System.out.println(result);
// [
//  Entity(code=code2, name=Name2, version=2), 
//  Entity(code=code1, name=Name1, version=3), 
//  Entity(code=code1, name=Name1, version=3)
// ]