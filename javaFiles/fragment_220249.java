import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

@SuppressWarnings("serial")
public class Traff2 extends JPanel {
    public Traff2() {
        Traff2LightPanel lightPanel = new Traff2LightPanel();
        Traff2LightControlsPanel controlsPanel = new Traff2LightControlsPanel(lightPanel);

        setLayout(new BorderLayout());
        add(lightPanel, BorderLayout.CENTER);
        add(controlsPanel, BorderLayout.PAGE_END);
    }

    private static void createAndShowGui() {
        Traff2 mainPanel = new Traff2();

        JFrame frame = new JFrame("Traffic");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}