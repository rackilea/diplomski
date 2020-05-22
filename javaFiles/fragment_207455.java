import static org.lwjgl.opengl.GL11.*;
import java.awt.Canvas;
import javax.swing.JFrame;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.vector.Vector3f;

public class RotateAboutCenter
{
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(500,500);
        f.setLocationRelativeTo(null);
        Canvas canvas = new Canvas();
        f.add(canvas);
        try
        {
            Display.setParent(canvas);
            f.setVisible(true);
            Display.create();
        }
        catch (LWJGLException e)
        {
            e.printStackTrace();
        }
        while (!Display.isCloseRequested())
        {
            draw();
            Display.update();
            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
            rotationAngleDeg += 1.0f;
        }
        Display.destroy();
    }

    private static float rotationAngleDeg = 0;

    // The vertices of the model
    private static Vector3f v0 = new Vector3f(10,10,0);
    private static Vector3f v1 = new Vector3f(20,10,0);
    private static Vector3f v2 = new Vector3f(20,20,0);
    private static Vector3f v3 = new Vector3f(10,20,0);

    // The center of the model
    private static Vector3f center = new Vector3f(15,15,0);

    private static void draw() 
    {
        // Basic setup of view etc.
        int w = Display.getWidth();
        int h = Display.getHeight();
        glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
        glViewport(0, 0, w, h);
        glMatrixMode(GL_PROJECTION);
        glLoadIdentity();
        GLU.gluPerspective(45, (float) w / (float) h, 0.1f, 1000);
        glMatrixMode(GL_MODELVIEW);
        glLoadIdentity();
        GLU.gluLookAt(0,0,70,0,0,0,0,1,0);

        glPushMatrix();

        // ===================================================================
        // Now, do the model transform. Remember that this has to 
        // be read "backwards":

        // THIRD STEP: Move the model back so that its center is
        // again at its original position
        glTranslatef(center.x, center.y, center.z);

        // SECOND STEP: Rotate the model about the origin (which now
        // is the center of the model)
        glRotatef(rotationAngleDeg,0,0,1);

        // FIRST STEP: Translate the model so that its center is at the origin
        glTranslatef(-center.x, -center.y, -center.z);

        // ===================================================================

        // Draw the object, with its original coordinates. All the
        // transforms are now contained in the MODELVIEW matrix.
        glBegin(GL_TRIANGLES);
        glColor3f(1,0,0);
        glVertex3f(v0.x, v0.y, v0.z);
        glVertex3f(v1.x, v1.y, v1.z);
        glVertex3f(v3.x, v3.y, v3.z);
        glVertex3f(v1.x, v1.y, v1.z);
        glVertex3f(v2.x, v2.y, v2.z);
        glVertex3f(v3.x, v3.y, v3.z);

        glEnd();
        glPopMatrix();
    }
}