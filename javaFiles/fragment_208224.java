public class main {

public static JFrame frame;
public static JPanel panel, option, keys;
public static JButton A, B, C, D, E, F, G, A3, C3, D3, F3, G3;
public static AudioInputStream audioInputStream;
public static Clip clip;
public static boolean octave1, octave2;

public static void start() {
    frame = new JFrame("PIANO");
    frame.setPreferredSize(new Dimension(700, 500));
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);

    panel = new JPanel();
    panel.setOpaque(true);
    panel.setLayout(null);
    frame.setContentPane(panel);

    option = new JPanel();
    option.setOpaque(true);
    option.setSize(new Dimension(700, 100));
    option.setLocation(0, 0);
    option.setBackground(Color.GRAY);
    panel.add(option);

    //ADDED NEW

    oct1 = new JRadioButton("Low Octave");
    oct1.setSelected(true);
    oct1.addActionListener((ActionEvent ae) -> {

        oct2.setSelected(false);
        octave1 = true;
        octave2 = false;

    });
    option.add(oct1);

    oct2 = new JRadioButton("High Octave");
    oct2.addActionListener((ActionEvent ae) -> {

        oct1.setSelected(false);
        octave1 = false;
        octave2 = true;

    });

    //END OF NEW

    keys = new JPanel();
    keys.setOpaque(true);
    keys.setSize(new Dimension(700, 400));
    keys.setLocation(0, 100);
    keys.setLayout(null);
    panel.add(keys);

    C3 = new JButton();
    C3.setSize(new Dimension(60, 190));
    C3.setLocation(70, 0);
    C3.setBackground(Color.BLACK);
    C3.setOpaque(true);
    C3.addActionListener((ActionEvent ae) -> {

        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("C_s.wav").getAbsoluteFile());

            // create clip reference
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);

            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

    });
    keys.add(C3);

    D3 = new JButton();
    D3.setSize(new Dimension(60, 190));
    D3.setLocation(170, 0);
    D3.setBackground(Color.BLACK);
    D3.setOpaque(true);
    D3.addActionListener((ActionEvent ae) -> {

        try {
            audioInputStream = AudioSystem.getAudioInputStream(new File("D_s.wav").getAbsoluteFile());

            // create clip reference
            clip = AudioSystem.getClip();

            // open audioInputStream to the clip
            clip.open(audioInputStream);

            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

    });
    keys.add(D3);

    frame.pack();
    frame.setVisible(true);

}
}