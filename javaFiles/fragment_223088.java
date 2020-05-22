class Rectangle extends Shape{
   public boolean isIntersecting(Circle circle){ 
      return Shapes.isIntersecting(this, circle);
   }  
} 

class Circle extends Shape{
   public boolean isIntersecting(Rectangle rectangle){
       return Shapes.isIntersecting(rectangle, this);
   }  
}

class Shapes{
    static boolean isIntersecting(Rectangle rectangle, Circle circle){
       // implementation goes here
    }
}