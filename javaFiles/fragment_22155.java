public class Circle {   
    private double radius;
    private static int numberOfCircles = 0;
    public Circle (double radius){
      this.radius = radius;
      numberOfCircles++;
      System.out.println("The circumference : " + getCircumference());
      System.out.println("The area : " + getArea());
    }

    public double getRadius (){
      return radius;
    }
    public double getArea (){
      return 3.14*radius*radius;
    }
    public double getCircumference (){
      return 2*3.14*radius;
    }

    public static int getNumberOfCirclesCreated(){
       return numberOfCircles;
    }
}


public class TestCircle {
  public static void main (String args []) {
      Circle [] circles = new Circle [10];
      for(int counter=0;counter< circles.length;counter++){
         circles[counter]=new Circle((double)(counter+1));
      }
      System.out.println("Number of circles : " + Circle.getNumberOfCirclesCreated());
   }
}