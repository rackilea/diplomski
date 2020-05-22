final Map<Integer, Map<Integer, Direction>> map = path.stream().collect(
        Collectors.groupingBy(
                step -> step.getCoordinate().getY(),
                Collectors.toMap(
                        step -> step.getCoordinate().getX(),
                        step -> step.getDirection())));