public class Rectangle
{
    // instance variables 
    private int length;
    private int width;

    /**
     * Constructor for objects of class rectangle
     */
    public Rectangle(int l, int w)
    {
        // initialise instance variables
        length = l;
        width = w;
    }

    // return the height
    public int getLength()
    {
        return length;
    }
    public int getWidth()
    {
        return width;
    }

    @Override
    public String toString() 
    {
         // TODO Auto-generated method stub     
         return length + " X " + width;
    }
}

class Main{
    public static void main(String[] args) {       
          Rectangle test = new Rectangle(3, 4);
          System.out.println(test.toString());
       }
}