Set<String> models = Set.of("Focus", "Civic");

return reportElements.stream()
           .map( Car::getModel )
           .filter( models::contains )
           .distinct()
           .limit( models.size() )
           .count() == models.size();