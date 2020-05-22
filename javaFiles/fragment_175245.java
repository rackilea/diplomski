package de.professional_webworkx.vlcj;

import java.awt.BorderLayout;
import java.awt.Canvas;

import javax.swing.JPanel;

import uk.co.caprica.vlcj.binding.LibVlc;
import uk.co.caprica.vlcj.player.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;
import uk.co.caprica.vlcj.player.embedded.videosurface.CanvasVideoSurface;
import uk.co.caprica.vlcj.runtime.RuntimeUtil;

import com.sun.jna.Native;

public class VideoPanel extends JPanel {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private EmbeddedMediaPlayer mediaPlayer;
    private Canvas _canvas;
    private String mediaPath;

    public VideoPanel(final String mediaPath) {

        this.mediaPath  = mediaPath;
        setLayout(new BorderLayout(10, 10));
        _canvas = new Canvas();
        add(_canvas, BorderLayout.CENTER);

        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        MediaPlayerFactory mediaPlayerFactory = new MediaPlayerFactory();
        CanvasVideoSurface videoSurface = mediaPlayerFactory.newVideoSurface(_canvas);
        mediaPlayer = mediaPlayerFactory.newEmbeddedMediaPlayer();
        mediaPlayer.setVideoSurface(videoSurface);
    }

    public void startPlayer() {
                mediaPlayer.playMedia(mediaPath);
    }


}