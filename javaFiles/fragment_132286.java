ArrayList<ShapeClass> allShape = new ArrayList<>();
    allShape.addAll(emptyRectangle);
    allShape.addAll(filledRectangles);
    allShape.addAll(lineArray);

    for(ShapeClass shape: allShape) {
        shape.paint();   // make sure you have a paint() method in the ShapeClass, and it is overriden in the subclass. 
    }