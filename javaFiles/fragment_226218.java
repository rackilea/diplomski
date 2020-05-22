PathTransition pathTransition = PathTransitionBuilder.create()
        .duration(Duration.seconds(6))
        .path(path)
        .node(rect)
        .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
        .cycleCount(Timeline.INDEFINITE)
        .autoReverse(false)
        .build();