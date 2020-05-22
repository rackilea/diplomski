import java.util.*;
import javax.swing.*;
import java.awt.BorderLayout;

class ToneList implements Runnable {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new ToneList());
    }

    enum Tone {…} // same as above

    @Override
    public void run() {
        final JFrame   frame = new JFrame();
        final JPanel content = new JPanel(new BorderLayout());
        final JList     list = new JList(Tone.values());
        final JButton button = new JButton("Play");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object[] values = list.getSelectedValues();
                double[] chord  = new double[values.length];

                for(int i = 0; i < chord.length; ++i) {
                    Tone tone = (Tone)values[i];
                    chord[i]  = tone.hz;
                }

                JOptionPane.showMessageDialog(null,
                    "Chord selected: " + Arrays.toString(chord)
                );
            }
        });

        content.add(list, BorderLayout.CENTER);
        content.add(button, BorderLayout.SOUTH);

        frame.setContentPane(content);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}