class Point{
    int x;
    int y;

    public void setX(int x){
         this.x = x;
    }

    public int getX(){
        return this.x;
    }
}



public class Lab1 {

    public static void main(String[] args) {
        Point A = new Point();
        A.setX(1);      
        System.out.println(A.getX());

    }
}