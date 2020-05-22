import java.awt.*;
import javax.media.opengl.glu.GLU;

void setup()
{
    frameRate(-1);
    beginPGL();
    GLU.getCurrentGL().getGL2().setSwapInterval(1);
    endPGL();
}