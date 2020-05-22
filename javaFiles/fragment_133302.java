public Shape makeBlock(double length, double width, double height)
{
    Shape shape= new Block( length,  width, height);
    shapecollection.addShape(shape);
    return shape;
}