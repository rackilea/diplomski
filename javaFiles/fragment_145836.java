public class Shape{
    private PShape myShape;
    private String name;
    private PApplet drawer;
    public Shape(PApplet drawer, String name){
       //constructor
       this.drawer = drawer;
       this.name = name;
       myShape = drawer.createShape();
    }
}