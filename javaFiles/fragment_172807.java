ShapeFactoryType abFac = new ShapeFactoryType();

    ShapeFactory factory = null;
    Shape s = null;
    //returns a ShapeFactory but whether it is a
    //SimpleShapeFactory or a ComplexShapeFactory is not known to the caller.
    factory = abFac.getShapeFactory(1);//returns SimpleShapeFactory
    //returns a Shape but whether it is a Circle or a Pentagon is
    //not known to the caller.
    s = factory.getShape(2); //returns square.
    s.draw(); //draws a square
    //returns a ShapeFactory but whether it is a
    //SimpleShapeFactory or a ComplexShapeFactory is not
    //known to the caller.
    factory = abFac.getShapeFactory(2);
    //returns a Shape but whether it is a Circle or a Pentagon is
    //not known to the caller.
    s = factory.getShape(3); //returns a pentagon.
    s.draw(); //draws a pentagon