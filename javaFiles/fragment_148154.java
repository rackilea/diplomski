import java.awt.Container;

import processing.core.PApplet;
import processing.core.PImage;

public class Menu extends PApplet
{
    private static final long serialVersionUID = -6557167654705489372L;

    PImage background;
    static String tab = "";

    //simple constructor
    public Menu()
    {

    }

    public void setup()
    {
        size(600, 400);
        smooth();

        background = loadImage("C:/temp/background.jpg");
    }

    public void draw()
    {
        image(background, 0, 0);
    }

    public void mousePressed()
    {
        Container p = getParent();
        tab = "";

        // FIRST WAY OF ACCESSING PARENT FRAME
        while(p != null)
        {
            //printParentTree(p);
            if(p instanceof ExampleFrame)
            {
                ExampleFrame myframe = (ExampleFrame)p;
                myframe.sampleMethod("First Way");
                break;
            }
            p = p.getParent();
        }

        // SECOND WAY OF ACCESSING PARENT FRAME     
        if(frame != null && (frame instanceof ExampleFrame))
        {
            ExampleFrame myframe = (ExampleFrame)p;
            myframe.sampleMethod("Second Way");
        }
    }

    void printParentTree(Container p) 
    {
        System.out.println(tab+p.getClass().getName());
        tab +='\t';
    }
}