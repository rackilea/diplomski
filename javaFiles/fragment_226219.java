PathTransitionBuilder pathTransitionBuilder = PathTransitionBuilder.create();
pathTransitionBuilder .duration(Duration.seconds(6));
pathTransitionBuilder .path(path);
pathTransitionBuilder .node(rect);
pathTransitionBuilder .orientation(OrientationType.ORTHOGONAL_TO_TANGENT);
pathTransitionBuilder .cycleCount(Timeline.INDEFINITE);
pathTransitionBuilder .autoReverse(false);
PathTransition pathTransition = pathTransitionBuilder.build();