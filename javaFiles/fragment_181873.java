public abstract class Mouse implements Hp {
    char manufacturer;
    char type;
    static int scroll;
    boolean click;

    public static void main(String[] args){
    }

    public void scrollUp(int increment){
        scroll = scroll + increment;
        System.out.println("The mouse is scrolling up");
    }
    public  void scrollDown (int decrement){
        int scrollDown = scroll - decrement;
        System.out.println("The mouse is scrolling down");
    }

    public void rightClick(){
        boolean rightClick = true;  
        System.out.println("The mouse is right Clicking");
    }

    public void leftClick(){
        boolean leftClick = true;
        System.out.println("The mouse is left Clicking");
    }
}