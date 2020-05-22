List<?> list = new ArrayList();
 List<MyConcreteType> collect1 = 
     list.stream()
         .filter(MyConcreteType.class::isInstance)
         .map(MyConcreteType.class::cast)
         .collect(Collectors.toList());