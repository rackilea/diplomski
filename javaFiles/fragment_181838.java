package com.ggl.testing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class SimonShape implements Runnable {

    private GameModel gameModel;

    private JFrame frame;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new SimonShape());
    }

    public SimonShape() {
        this.gameModel = new GameModel();
    }

    @Override
    public void run() {
        frame = new JFrame("Simon Says");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        DrawingPanel drawingPanel = new DrawingPanel();
        frame.add(drawingPanel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        GameRunnable runnable = new GameRunnable(drawingPanel, gameModel);
        new Thread(runnable).start();
    }

    public class DrawingPanel extends JPanel {

        private static final long serialVersionUID = 70146219705119575L;

        private List<ArcModel> segments;

        public DrawingPanel() {
            this.segments = new ArrayList<ArcModel>();

            int margin = 50;
            int diameter = 300;
            Rectangle r = new Rectangle(margin, margin, diameter, diameter);

            segments.add(new ArcModel(Color.GREEN, r, 180, 90, Arc2D.PIE));
            segments.add(new ArcModel(Color.BLUE, r, 270, 90, Arc2D.PIE));
            segments.add(new ArcModel(Color.RED, r, 360, 90, Arc2D.PIE));
            segments.add(new ArcModel(Color.YELLOW, r, 90, 90, Arc2D.PIE));

            int width = diameter + margin + margin;
            this.setPreferredSize(new Dimension(width, width));
        }

        public void brighterArcModelColor(int index) {
            segments.get(index).brighterColor();
            repaint();
        }

        public void darkerArcModelColor(int index) {
            segments.get(index).darkerColor();
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D) g;

            for (ArcModel arcModel : segments) {
                g2d.setPaint(arcModel.getColor());
                Rectangle r = arcModel.getRectangle();
                g2d.fill(new Arc2D.Double(r.getX(), r.getY(), r.getWidth(), r
                        .getHeight(), arcModel.getStartingAngle(), arcModel
                        .getExtent(), arcModel.getClosureType()));
            }
        }

    }

    public class ArcModel {

        private final int closureType;

        private final double startingAngle;
        private final double extent;

        private Color color;
        private final Color originalColor;

        private final Rectangle rectangle;

        public ArcModel(Color color, Rectangle rectangle, double startingAngle,
                double extent, int closureType) {
            this.color = color;
            this.originalColor = color;
            this.rectangle = rectangle;
            this.startingAngle = startingAngle;
            this.extent = extent;
            this.closureType = closureType;
        }

        public int getClosureType() {
            return closureType;
        }

        public double getStartingAngle() {
            return startingAngle;
        }

        public double getExtent() {
            return extent;
        }

        public Rectangle getRectangle() {
            return rectangle;
        }

        public Color getColor() {
            return color;
        }

        public void brighterColor() {
            this.color = Color.WHITE;
        }

        public void darkerColor() {
            this.color = originalColor;
        }

    }

    public class GameModel {

        private List<Integer> computerSequence;
        private List<Integer> playerSequence;

        private Random random;

        public GameModel() {
            this.computerSequence = new ArrayList<Integer>();
            this.playerSequence = new ArrayList<Integer>();
            this.random = new Random();
        }

        public void addToComputerSequence() {
            computerSequence.add(Integer.valueOf(random.nextInt(4)));
        }

        public void clearComputerSequence() {
            computerSequence.clear();
        }

        public List<Integer> getComputerSequence() {
            return computerSequence;
        }

        public void clearPlayerSequence() {
            playerSequence.clear();
        }

        public void addToPlayerSequence(int number) {
            playerSequence.add(Integer.valueOf(number));
        }

        public boolean doSequencesMatch() {
            if (computerSequence.size() == playerSequence.size()) {
                for (int i = 0; i < computerSequence.size(); i++) {
                    int computer = computerSequence.get(i);
                    int player = playerSequence.get(i);
                    if (computer != player) {
                        return false;
                    }
                }

                return true;
            }

            return false;
        }

    }

    public class GameRunnable implements Runnable {

        private volatile boolean running;

        private DrawingPanel drawingPanel;

        private GameModel gameModel;

        public GameRunnable(DrawingPanel drawingPanel, GameModel gameModel) {
            this.drawingPanel = drawingPanel;
            this.gameModel = gameModel;
        }

        @Override
        public void run() {
            running = true;
            while (running && gameModel.getComputerSequence().size() < 10) {
                generateComputerSequence();
                sleep(1800L);
            }
        }

        private void generateComputerSequence() {

            gameModel.addToComputerSequence();
            for (Integer index : gameModel.getComputerSequence()) {
                drawingPanel.brighterArcModelColor(index);
                sleep(1000L);
                drawingPanel.darkerArcModelColor(index);
                sleep(200L);
            }

        }

        private void sleep(long duration) {
            try {
                Thread.sleep(duration);
            } catch (InterruptedException e) {

            }
        }

        public synchronized void setRunning(boolean running) {
            this.running = running;
        }

    }

}