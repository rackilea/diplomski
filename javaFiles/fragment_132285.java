for(ShapeClass shape: allShapes) {
        System.out.println(shape.getClass()); // class <actual class>
        if(shape instanceof Triangle) {
            Triangle tri = (Triangle) shape;
            tri.paint();
        } else if(shape instanceof Rectangle) {
            Rectangle rec = (Rectangle) shape;
            rec.paint();
        }
    }