public class Point3D {  
    int x=1;  
    public static void main(String args[]) {   
      Point3D  p = new Point3D(); 
        p.setX(1);
        int x=p.getX();
        System.out.println(x);
    }

    public void setX(int x) { 
        this.x=x;
    }

     public int getX() { 
        return this.x;
    }   
}