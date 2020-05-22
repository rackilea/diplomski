import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.nio.file.*;
import java.util.*;
import javax.sound.sampled.*;
import javax.swing.*;

public class SlideShow extends JFrame {

    private JPanel slides;
    private int slideIndex;
    private java.util.List<String> soundPaths;
    private CardLayout layoutManager;
    private JButton btnPrev;
    private JButton btnNext;
    private JButton btnHome;
    private JButton btnSound;

    public SlideShow() {
        super();

        setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        btnPrev = new JButton("Previous");
        btnNext = new JButton("Next");
        btnHome = new JButton("Home");
        btnSound = new JButton("Sound");
        btnPrev.setIcon(createIcon("/resources/back+button.png"));
        btnNext.setIcon(createIcon("/resources/next2.png"));
        btnHome.setIcon(createIcon("/resources/home_icons.png"));
        btnSound.setIcon(createIcon("/resources/Media-Controls-Volume-Down-icon.png"));

        slides = new JPanel();
        slides.setBackground(Color.WHITE);
        slides.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        slides.setLayout(layoutManager = new CardLayout(0,0));

        soundPaths = new ArrayList<>();
        String directory = "resources/images-and-sounds/";
        for(int i=2; i<=24; i++){
            final String name = "/resources/" + i + ".png";
            slides.add(i + ".png", new JLabel(createIcon(name)));
            //slides.add(i+".png", new JLabel(new ImageIcon(directory + i + ".png")));
            soundPaths.add(directory + i + ".wav");
        }
        add(slides);

        add(btnHome);
        add(btnPrev);
        add(btnNext);
        add(btnSound);

        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layoutManager.previous(slides);
                slideIndex = (slideIndex > 0)
                        ? slideIndex - 1
                        : slides.getComponentCount() - 1;
            }
        });

        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                layoutManager.next(slides);
                slideIndex = (slideIndex + 1) % slides.getComponentCount();
            }
        });

        btnHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                close();
                Frame fr = new Frame();
                fr.setVisible(true);
                slideIndex = 0;
            }
        });

        btnSound.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //music("././build/classes/resources/test.wav");

                if (Files.exists(Paths.get(soundPaths.get(slideIndex)))) {
                    music(soundPaths.get(slideIndex));
                }
            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,530);
    }

    private ImageIcon createIcon(String name) {
        return new ImageIcon(getClass().getResource(name));
    }

    public void close(){
        super.dispose();
    }

    public static void music(String path)
    {
        // https://stackoverflow.com/a/30587573/1694043
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(new File(path)));
            clip.start();
            //clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | IOException
                | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) {
        SlideShow frame = new SlideShow();
        frame.setVisible(true);
    }
}