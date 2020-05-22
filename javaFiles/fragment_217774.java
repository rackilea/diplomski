import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JFrame;
import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.windows.Win32FullScreenStrategy;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

public class Test extends JFrame {

  static Test frame;
  static Canvas canvas;
  static int video = 1;

    public Test() {
        canvas = new Canvas();
          canvas.setBackground(Color.BLACK);
        add(canvas);
    }

    public static void main(String[] args) {
        frame = new Test();
          frame.setSize(1047,615);
          frame.setLocationRelativeTo(null);
          frame.setResizable(false);
          frame.setVisible(true);
          frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(),"C:\\Program Files\\VideoLAN\\VLC");
          Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
          MediaPlayerFactory mpf = new MediaPlayerFactory();
          EmbeddedMediaPlayer emp = mpf.newEmbeddedMediaPlayer(new Win32FullScreenStrategy(frame));
            emp.setVideoSurface(mpf.newVideoSurface(canvas));

            if (video==1) {
                emp.prepareMedia(url("introVideo.mp4"));
                emp.play();
            }
            if (video==2) {
                //Another video
            }
    }

    static String url (String video) {
        String mrl = new Object().getClass().getResource("/media/guide.txt").getFile();
        String url = mrl.replace("/", "\\").split("\\\\",2)[1].split("Surprise")[0].concat("Surprise\\videos\\"+video);
          return url;
    }
}