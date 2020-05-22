import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class SimpleGui3C {

    @SuppressWarnings("serial")
    private static void createAndShowGui() {
        final MyDrawPanel gui = new MyDrawPanel();

        JButton drawButton = new JButton(new AbstractAction("Randomize") {

            @Override
            public void actionPerformed(ActionEvent arg0) {
                gui.randomizeColor();
            }
        });

        JFrame frame = new JFrame("SimpleGui3C");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(gui);
        frame.getContentPane().add(drawButton, BorderLayout.PAGE_END);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}