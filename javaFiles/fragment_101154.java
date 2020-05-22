Comparator<Entity> comparator = Comparator.comparing(Entity::getPrice,
                                                     Comparator.reverseOrder());
comparator = comparator.thenComparing(Entity::getProdName, 
                                      Comparator.reverseOrder());
comparator = comparator.thenComparingLong(Entity::getId);

list = list.stream().sorted(comparator).collect(Collectors.toList());
list.stream().forEachOrdered(l -> System.out.println(l.getId() + " : " + l.getPrice() + " : " + l.getProdName()));