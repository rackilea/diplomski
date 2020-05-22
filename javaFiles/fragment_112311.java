public class DrawingSpace extends JPanel
{
    private Dog dog;

    public DrawingSpace(){
        dog = new Dog();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        dog.draw(g);   //will invoke Dog's draw method and draw a dog
    }
}