class ShapeVisitor<T>
{
    T visitCircle(Circle circle);
    T visitSquare(Square square);
}

class Shape
{
    abstract <T> T accept(ShapeVisitor<T> visitor);

    // methods of Class Shape
}

class Circle extends Shape
{
   <T> T accept(ShapeVisitor<T> visitor) {
       return visitor.visitCircle(this);
   }

   // methods of Class Circle 
}

class Square extends Shape
{
   <T> T accept(ShapeVisitor<T> visitor) {
       return visitor.visitSquare(this);
   }

  // methods of Class Square 
}

Class Canvas  
{  
    void drawAll()  
    {  
        for (Shape s : heterogeneousCollection)  
        {  
            s.draw();
            s.accept(new ShapeVisitor<Void>() {
                @Override Void visitCircle(Circle circle) {
                    circle.xyz();
                    return null;
                }

                @Override Void visitSquare(Square square) {
                    square.abc();
                    return null;
                }
            }
        }   
    }  
}