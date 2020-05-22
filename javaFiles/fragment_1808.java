return optionalTown.map(town ->
   town.getSchool()
       .getSubjects()
       .stream()
       .map(Subject::getName)
       .collect(Collectors.toList())
).orElse(Collections.emptyList());