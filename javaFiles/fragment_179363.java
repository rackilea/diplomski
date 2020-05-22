Shape [] shape = new Shape [5];
    shape[0] = objCircle;
    shape[1] = objSquare;
    shape[2] = objTriangle;
    shape[3] = objSphere;
    shape[4] = objCube;
    shape[5] = objTetra;
    for(int i = 0; i<Shape.length; i++)
    {
       //Problem occured in this section of code
        System.out.println(Shape[i].getArea());
    }