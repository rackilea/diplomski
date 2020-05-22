import java.awt.BorderLayout;    
import javax.swing.JFrame;    
import processing.core.PApplet;

public class ExampleFrame extends JFrame
{
    private static final long serialVersionUID = 4792534036194728580L;
    PApplet app;

    public ExampleFrame(PApplet emApp)
    {
        super("Ball Maze Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(200, 200);

        app = emApp;
        setSize(615,438);
        setVisible(true);

        setLayout(new BorderLayout());

        add(app, BorderLayout.CENTER);

        // Setting my frame object
        app.frame = this;       
        app.init();
    }

    // Sample Method
    public void sampleMethod(String msg)
    {
        System.out.println("I think '"+ msg +"' called me !!");
    }
}