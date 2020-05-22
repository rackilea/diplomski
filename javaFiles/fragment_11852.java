import java.util.*;
import javax.swing.*;
import java.awt.BorderLayout;

class ToneBox implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ToneBox());
    }

    enum Tone {
        C(261.6),
        CSHARP(277.2),
        D(293.7),
        DSHARP(311.2),
        E(329.6),
        F(349.6),
        FSHARP(370),
        G(391.9),
        GSHARP(415.3),
        A(440),
        ASHARP(466.2), // note: there was an error here
        B(493.9);      // A -> A# -> B, not A -> B -> H

        final double hz;

        Tone(double hz) {
            this.hz = hz;
        }

        double[] triad() {
            List<Tone> values = Arrays.asList(Tone.values());
            double[] chord = new double[3];

            int myIndex = values.indexOf(this);

            // form a triad using the intervals
            // as relative indexes in to the list
            chord[0] = this.hz;
            chord[1] = values.get((myIndex + 4) % values.size()).hz;
            chord[2] = values.get((myIndex + 7) % values.size()).hz;

            return chord;
        }

        // override toString, which JComboBox
        // uses to display, so we can put
        // Tone objects in the box directly

        @Override
        public String toString() {
            return this.name().replace("SHARP", "#");
        }
    }

    @Override
    public void run() {
        final JFrame   frame = new JFrame();
        final JPanel content = new JPanel(new BorderLayout());
        final JComboBox  box = new JComboBox(Tone.values());
        final JButton button = new JButton("Play");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                // overriding toString makes it much
                // easier for us to retrieve the
                // enum values from the JComboBox

                Tone tone = (Tone)box.getSelectedItem();
                double[] chord = tone.triad();

                JOptionPane.showMessageDialog(null,
                    "Chord selected: " + Arrays.toString(chord)
                );
            }
        });

        content.add(box, BorderLayout.CENTER);
        content.add(button, BorderLayout.SOUTH);

        frame.setContentPane(content);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}