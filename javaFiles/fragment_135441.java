List<Person> merged = findPerson.stream()
    .collect( 
        Collectors.collectingAndThen(
            Collectors.toMap( 
                (p) -> new AbstractMap.SimpleEntry<>( p.getName(), p.getAge() ), 
                Function.identity(), 
                (left, right) -> { 
                    left.getAddress().addAll( right.getAddress() ); 
                    return left; 
                }
            ),        
            ps -> new ArrayList<>( ps.values() ) 
        ) 
    )
;