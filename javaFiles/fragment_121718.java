Predicate<Parent>  first= e -> e.getAttrib1().equals("nanu"); 
Predicate<Parent>  second= e -> e.getAttrib2().equals(".."); 

List<Parent> temp = objList.stream()
            .filter(first)   // Similarly you can call second
            .collect(Collectors.toList());