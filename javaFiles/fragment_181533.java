import javax.swing.*;

public class RadioMenuDemo {

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
                JPanel gui = new JPanel();

                JMenuBar mb = new JMenuBar();
                JMenu shapes = new JMenu("Draw");
                mb.add(shapes);
                ButtonGroup bg = new ButtonGroup();
                shapes.setMnemonic('D');

                JRadioButtonMenuItem line = new JRadioButtonMenuItem("Line");
                line.setAccelerator(KeyStroke.getKeyStroke("L"));
                shapes.add(line);
                bg.add(line);

                JRadioButtonMenuItem oval = new JRadioButtonMenuItem("Oval");
                oval.setAccelerator(KeyStroke.getKeyStroke("O"));
                shapes.add(oval);
                bg.add(oval);

                JRadioButtonMenuItem rect = new JRadioButtonMenuItem("Rectangle");
                rect.setAccelerator(KeyStroke.getKeyStroke("R"));
                shapes.add(rect);
                bg.add(rect);

                JFrame f = new JFrame("Radio menu items");
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                f.setJMenuBar(mb);
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        };
        SwingUtilities.invokeLater(r);
    }
}