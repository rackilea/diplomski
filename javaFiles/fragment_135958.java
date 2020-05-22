import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private RandomButtonPane pane;

        public TestPane() {
            setLayout(new BorderLayout());

            JPanel actions = new JPanel();

            JButton random = new JButton("Random");
            JButton save = new JButton("Save");
            JButton load = new JButton("Load");

            actions.add(random);
            actions.add(save);
            actions.add(load);

            add(actions, BorderLayout.SOUTH);

            random.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (pane != null) {
                        remove(pane);
                    }

                    pane = new RandomButtonPane();
                    pane.randomise();
                    add(pane);

                    Window window = SwingUtilities.windowForComponent(TestPane.this);
                    window.pack();
                    window.setLocationRelativeTo(null);
                }
            });

            save.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (pane != null) {
                        try (OutputStream os = new FileOutputStream(new File("Save.dat"))) {
                            try (XMLEncoder encoder = new XMLEncoder(os)) {
                                encoder.writeObject(pane);
                                remove(pane);
                                pane = null;
                            }
                        } catch (IOException exp) {
                            exp.printStackTrace();
                        }
                    }
                }
            });

            load.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (pane != null) {
                        remove(pane);
                        pane = null;
                    }

                    try (InputStream is = new FileInputStream(new File("Save.dat"))) {
                        try (XMLDecoder decoder = new XMLDecoder(is)) {
                            Object value = decoder.readObject();
                            if (value instanceof RandomButtonPane) {
                                pane = (RandomButtonPane)value;
                                pane.revalidate();
                                add(pane);
                            }
                        }
                    } catch (IOException exp) {
                        exp.printStackTrace();
                    }
                    Window window = SwingUtilities.windowForComponent(TestPane.this);
                    window.pack();
                    window.setLocationRelativeTo(null);
                }
            });
        }

    }

    public static class RandomButtonPane extends JPanel {

        public RandomButtonPane() {
            setLayout(new GridBagLayout());
        }

        public void randomise() {
            int count = ((int) (Math.random() * 100)) + 1;
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            for (int index = 0; index < count; index++) {
                if (index % 10 == 0) {
                    gbc.gridx = 0;
                    gbc.gridy++;
                }
                add(new JButton(Integer.toString(index)), gbc);
                gbc.gridx++;
            }
        }
    }

}