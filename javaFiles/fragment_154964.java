import java.awt.Frame;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class MyFrame
{
  public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, ParseException
  {

    UIManager.setLookAndFeel("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");


    final JFrame frame = new JFrame("My Frame")
    {

      @Override
      public Rectangle getMaximizedBounds()
      {
        Insets screenInsets = getToolkit().getScreenInsets(getGraphicsConfiguration());
        Rectangle screenSize = getGraphicsConfiguration().getBounds();
        Rectangle maxBounds = new Rectangle(screenInsets.left + screenSize.x, screenInsets.top + screenSize.y,
            screenSize.x + screenSize.width - screenInsets.right - screenInsets.left, screenSize.y + screenSize.height
                - screenInsets.bottom - screenInsets.top);
        return maxBounds;
      }

    };

    frame.setVisible(true);
    frame.setTitle("My Frame GUI Example");
    frame.setSize(400, 200);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    final IconizeWindowState state= new IconizeWindowState();

    frame.addWindowStateListener(new WindowAdapter()
    {
      @Override
      public void windowStateChanged(WindowEvent we)
      {
        //System.out.println("Old State = " + we.getOldState());
        //System.out.println("New State = " + we.getNewState());
        //System.out.println("################################");
        int oldState = we.getOldState();
        int newState = we.getNewState();
        //Check weather window iconized from maximize state or not.
        if (oldState != Frame.NORMAL)
        {
          if ((oldState & Frame.ICONIFIED) == 0 && (newState & Frame.ICONIFIED) != 0)
          {
            //System.out.println("Frame was iconized");
            frame.setMaximizedBounds(null);
            frame.setExtendedState(JFrame.ICONIFIED);
            //window iconized from maximize state.
            state.iconizeFromMaximizedState = true;
          }
        }

        if ((oldState & Frame.ICONIFIED) != 0 && (newState & Frame.ICONIFIED) == 0)
        {
          if (state.iconizeFromMaximizedState)
          {
            //System.out.println("Frame was deiconized");
            frame.setMaximizedBounds(frame.getMaximizedBounds());
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            state.iconizeFromMaximizedState = false;
          }
        }

      }
    });

  }
}

class IconizeWindowState
{
  boolean iconizeFromMaximizedState = false;
}