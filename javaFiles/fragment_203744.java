class Point{

    int x;
    int y;

    public Point(int a, int b){
        x = a;
        y = b;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
  }

  class TestCode{

    public static void main(String args[]){
       Point obj1 = new Point(1, 2);
       Point obj2 = newFunction();
       System.out.println(obj1.x + " " + obj1.y);
       System.out.println(obj2.getX() + " " + obj2.getY());
   }

       public static Point newFunction(){
           return new Point(9, 9);
       }    
 }