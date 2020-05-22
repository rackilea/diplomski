package de.professional_webworkx.vlcj;

import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.component.EmbeddedMediaListPlayerComponent;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;

/**
 * Hello world!
 *
 */
public class App 
{
    private static EmbeddedMediaListPlayerComponent component;
    public static void main( String[] args )
    {
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new App();

            }
        });
    }

    private App() {
        new VideoFrame();
    }
}