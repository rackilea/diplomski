import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.event.*;

import java.awt.Dimension;
import java.awt.BorderLayout;
import java.io.File;
import java.io.IOException;

public class PlaybackSlider implements Runnable, ActionListener {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new PlaybackSlider());
    }

    JButton open;
    JButton play;
    JSlider slider;
    JLabel label;

    File file;
    PlaybackLoop player;

    @Override
    public void run() {
        JFrame frame = new JFrame("Playback Slider");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel content = new JPanel(new BorderLayout()) {
            @Override
            public Dimension getPreferredSize() {
                Dimension pref = super.getPreferredSize();
                pref.width = 480;
                return pref;
            }
        };

        slider = new JSlider(JSlider.HORIZONTAL, 0, 1000, 0);
        content.add(slider, BorderLayout.CENTER);

        JToolBar bar = new JToolBar(JToolBar.HORIZONTAL);
        bar.setFloatable(false);
        content.add(bar, BorderLayout.SOUTH);

        open = new JButton("Open");
        play = new JButton("Play");

        open.addActionListener(this);
        play.addActionListener(this);

        label = new JLabel("");

        bar.add(open);
        bar.add(new JLabel(" "));
        bar.add(play);
        bar.add(new JLabel(" "));
        bar.add(label);

        frame.setContentPane(content);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        if(source == open) {
            File f = getFile();
            if(f != null) {
                file = f;
                label.setText(file.getName());
                stop();
            }
        }

        if(source == play) {
            if(file != null) {
                if(player != null) {
                    stop();
                } else {
                    start();
                }
            }
        }
    }

    File getFile() {
        JFileChooser diag = new JFileChooser();
        int choice = diag.showOpenDialog(null);

        if(choice == JFileChooser.APPROVE_OPTION) {
            return diag.getSelectedFile();
        } else {
            return null;
        }
    }

    void start() {
        try {
            player = new PlaybackLoop(file);
            new Thread(player).start();
            play.setText("Stop");
        } catch(Exception e) {
            player = null;
            showError("the file couldn't be played", e);
        }
    }

    void stop() {
        if(player != null) {
            player.stop();
        }
    }

    void showError(String msg, Throwable cause) {
        JOptionPane.showMessageDialog(null,
            "There was an error because " + msg +
            (cause == null ? "." : "\n(" + cause + ").")
        );
    }

    class PlaybackLoop implements Runnable {
        AudioInputStream in;
        SourceDataLine line;
        AudioFormat fmt;
        int bufferSize;

        boolean stopped;

        PlaybackLoop(File file) throws Exception {
            try {
                in = AudioSystem.getAudioInputStream(file);
                fmt = in.getFormat();

                bufferSize = (int)(fmt.getFrameSize() * (fmt.getSampleRate() / 15));

                line = AudioSystem.getSourceDataLine(fmt);
                line.open(fmt, bufferSize);
            } catch(Exception e) {
                if(in != null)
                    in.close();
                if(line != null)
                    line.close();
                throw e;
            }
        }

        void stop() {
            synchronized(this) {
                this.stopped = true;
            }
        }

        @Override
        public void run() {
            line.start();
            byte[] buf = new byte[bufferSize];

            try {
                try {
                    int b;
                    long elapsed = 0;
                    long total = in.getFrameLength();

                    for(;;) {
                        synchronized(this) {
                            if(stopped) {
                                break;
                            }
                        }

                        b = in.read(buf, 0, buf.length);
                        if(b < 0) {
                            break;
                        }

                        elapsed += b / fmt.getFrameSize();
                        updateSlider(elapsed, total);

                        line.write(buf, 0, b);
                    }
                } finally {
                    line.close();
                    in.close();
                }
            } catch(IOException e) {
                e.printStackTrace(System.err);
                showError("there was a problem during playback", e);
            }

            endOnEDT();
        }

        void updateSlider(double elapsed, double total) {
            final double amt = elapsed / total;
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    slider.setValue((int)Math.round(slider.getMaximum() * amt));
                }
            });
        }

        void endOnEDT() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    player = null;
                    slider.setValue(0);
                    play.setText("Play");
                }
            });
        }
    }
}