for(Point pointInGrid : buildTenByTenGrid()) {
            point = pointInGrid;
            if(objectUnderTest.shouldPointBeAdded(excludePoints, shape.contains(point))) {
                pointsInShape.add(point);
            }
        }