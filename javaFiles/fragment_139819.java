import java.awt.Color;

class ColorEnum {

    enum Color{BLUE,RED,YELLOW};

    public static void main(String[] args) {
        Color c = Color.BLUE;
        switch(c) {
            case BLUE:
                System.out.println("Blue!");
                break;
            case RED:
                System.out.println("Red!");
                break;
            case YELLOW:
                System.out.println("Yellow!");
                break;
            default:
                System.out.println("Logic error!");
        }
    }
}