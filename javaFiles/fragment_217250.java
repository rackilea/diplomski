import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;

public class Test {

    public static void createAndShowGUI() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        final JProgressBar progressBar = new JProgressBar();
        progressBar.setStringPainted(true);
        progressBar.setValue(0);
        progressBar.setBorderPainted(false);

        JButton startButton = new JButton("Start");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                UIDefaults defaults = new UIDefaults();
                defaults.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.GREEN));
                defaults.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.GREEN));

                progressBar.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                progressBar.putClientProperty("Nimbus.Overrides", defaults);

                SwingWorker worker = new SwingWorker() {
                    int current = 0, lengthOfTask = 100;

                    @Override
                    public Void doInBackground() {
                        while (current <= lengthOfTask && !isCancelled()) {

                            try { // dummy task
                                Thread.sleep(50);
                            } catch (InterruptedException ie) {
                            }

                            setProgress(100 * current / lengthOfTask);
                            current++;
                        }
                        return null;
                    }
                };
                worker.addPropertyChangeListener(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent pce) {

                        String strPropertyName = pce.getPropertyName();
                        if ("progress".equals(strPropertyName)) {
                            int progress = (Integer) pce.getNewValue();
                            progressBar.setValue(progress);

                            if (progressBar.getValue() == 50) {//change color on 50%
                                UIDefaults defaults = new UIDefaults();
                                defaults.put("ProgressBar[Enabled].foregroundPainter", new MyPainter(Color.RED));
                                defaults.put("ProgressBar[Enabled+Finished].foregroundPainter", new MyPainter(Color.RED));

                                progressBar.putClientProperty("Nimbus.Overrides.InheritDefaults", Boolean.TRUE);
                                progressBar.putClientProperty("Nimbus.Overrides", defaults);
                            }

                        }
                    }
                });
                worker.execute();
            }
        });

        JPanel holder = new JPanel();
        holder.add(progressBar);
        holder.add(startButton);

        frame.add(holder);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }
                createAndShowGUI();
            }
        });
    }
}

class MyPainter implements Painter<JProgressBar> {

    private final Color color;

    public MyPainter(Color c1) {
        this.color = c1;
    }
    @Override
    public void paint(Graphics2D gd, JProgressBar t, int width, int height) {
        gd.setColor(color);
        gd.fillRect(0, 0, width, height);
    }
}