import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

public class HomeWindow extends JFrame{

    public HomeWindow() {
        setTitle("look and feel demo");
        setSize(800, 600);
        setVisible(true);       
    }

        public static void main( String[] args )
        {
            EventQueue.invokeLater( new Runnable()
            {
                @Override
                public void run() 
                {
                    try
                    {
                        UIManager.setLookAndFeel( "com.seaglasslookandfeel.SeaGlassLookAndFeel" );
                         new HomeWindow();                      

                    }
                    catch ( Exception e )
                    {
                        e.printStackTrace();
                    }
                }
            } );
        }


}