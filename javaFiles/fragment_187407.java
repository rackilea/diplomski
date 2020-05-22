List<Environment> environmentList = 
    gameWorld.returnEnvironmentInCircle(unit.getLocation(), 
                                        unit.getType().getSensorRadius());

List<Environment> sortedEnvironmentList =
    environmentList.stream()
                   .sorted(Comparator.comparing(
                       unit -> unit.getLocation()
                                   .distanceTo(environment.getLocation()))
                   .collect(Collectors.toList());