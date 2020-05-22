List<Environment> environmentList = 
    gameWorld.returnEnvironmentInCircle(unit.getLocation(), 
                                        unit.getType().getSensorRadius());

environmentList.sort(
    Comparator.comparing(
        unit -> unit.getLocation().distanceTo(environment.getLocation()));