package widgets;

import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Window;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class WindowSnapper extends ComponentAdapter {

    private boolean locked = false;

    // feel free to modify; set based on my own preferences
    // incorporate as user option?
    private int sd = 30;
    private GraphicsDevice[] screenList  = GraphicsEnvironment
            .getLocalGraphicsEnvironment().getScreenDevices();  

    // clamping at 5 seems correct, 0 clamps at -5 beyond screen boundary
    public void componentMoved(ComponentEvent evt) {
        // gets current display device
        Window myWindow = new Window((Frame) evt.getComponent());
        GraphicsConfiguration config = myWindow.getGraphicsConfiguration();
        GraphicsDevice myScreen = config.getDevice();
        // matches against active display
        for(GraphicsDevice gd : getScreenList()) {
            // this will set the display to a new display if the window is moved to a new display
            if(gd.equals(myScreen)) {
                myScreen = gd;
                break;
            }
        }

        // minimising calls to stack
        int screenWidth = myScreen.getDefaultConfiguration().getBounds().width;
        int screenHeight = myScreen.getDefaultConfiguration().getBounds().height;
        int compWidth = evt.getComponent().getWidth();
        int compHeight = evt.getComponent().getHeight();
        int nx = evt.getComponent().getX();
        int ny = evt.getComponent().getY();
        // setting offsets in case of different screen
        int currentX = myScreen.getDefaultConfiguration().getBounds().x;
        int currentY = myScreen.getDefaultConfiguration().getBounds().y;

        // see end of method
        // OR conditions seem to stabilise movement when close to screen edge
        if(locked
                || nx == currentX + 5
                || ny == currentY + 5
                || nx == currentX + screenWidth - compWidth - 5
                || ny == currentY + screenHeight - compHeight - 5)
            return;

        // left
        if(nx < (currentX + sd) && nx > (currentX + 5)) {
            nx = currentX + 5;
        }

        // top
        if(ny < (currentY + sd) && ny > (currentY + 5)) {
            ny = currentY + 5;
        }

        // right
        if(nx > currentX + screenWidth - compWidth - sd
                && nx < currentX + screenWidth - compWidth - 5) {
            nx = currentX + screenWidth - compWidth - 5;
        }

        // bottom
        if(ny > currentY + screenHeight - compHeight - sd
                && ny < currentY + screenHeight - compHeight - 5) {
            ny = currentY + screenHeight - compHeight - 5;
        }

        // make sure we don't get into a recursive loop when the
        // set location generates more events
        locked = true;
        evt.getComponent().setLocation(nx, ny);
        locked = false;
    }

    public int returnSD() {
        return sd;
    }

    public void setSD(int sd) {
        this.sd = sd;
    }

    public GraphicsDevice[] getScreenList() {
        return screenList;
    }

    public void setScreenList(GraphicsDevice[] screenList) {
        this.screenList = screenList;
    }

}