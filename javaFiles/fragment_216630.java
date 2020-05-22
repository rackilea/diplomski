import static org.lwjgl.opengl.GL11.*;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.AWTGLCanvas;
import org.lwjgl.util.glu.GLU;

public class LwjglCanvasMouseEvents
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI()
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LwjglCanvas canvas = null;
        try
        {
            canvas = new LwjglCanvas();
        }
        catch (LWJGLException e)
        {
            e.printStackTrace();
        }
        canvas.addMouseListener(new MouseAdapter()
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
                System.out.println(e);
            }
        });
        f.getContentPane().add(canvas);
        f.setSize(400, 400);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }

}

class LwjglCanvas extends AWTGLCanvas
{
    private int currentWidth;
    private int currentHeight;

    public LwjglCanvas() throws LWJGLException
    {
        super();
    }

    @Override
    public void paintGL()
    {
        if (getWidth() != currentWidth || getHeight() != currentHeight)
        {
            currentWidth = getWidth();
            currentHeight = getHeight();
            glViewport(0, 0, currentWidth, currentHeight);
        }
        glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        glClear(GL_COLOR_BUFFER_BIT);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluOrtho2D(0.0f, currentWidth, 0.0f, currentHeight);

        glMatrixMode(GL_MODELVIEW);
        glPushMatrix();

        glBegin(GL_TRIANGLES);
        glColor3f(1.0f, 0.0f, 0.0f);
        glVertex3f(0, 0, 0);
        glColor3f(0.0f, 1.0f, 0.0f);
        glVertex3f(200, 0, 0);
        glColor3f(0.0f, 0.0f, 1.0f);
        glVertex3f(100, 200, 0);
        glEnd();

        glPopMatrix();
        try
        {
            swapBuffers();
        }
        catch (LWJGLException e)
        {
            e.printStackTrace();
        }
        repaint();
    }
}