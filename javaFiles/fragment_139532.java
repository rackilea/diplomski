import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Random;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Test {

    public static void main(String[] args) {
        new Test();
    }

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame();

                PlayField playField = new PlayField(200, 200, Color.DARK_GRAY);
                RobotModel model = new RobotModel();
                model.createNewRobot();

                RobotWorld world = new RobotWorld(playField, model);
                world.start();

                frame.add(world);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class RobotModel {

        public static final int MAX = 8;
        public LinkedList<Robot> bots = new LinkedList<Robot>();

        public void createNewRobot() {
            Robot temp = new Robot(40, 40, Color.BLUE);
            bots.addFirst(temp);
        }
    }

    public class PlayField {

        public int width;
        public int height;
        public Color fill_Color;

        PlayField(int width, int height, Color fill_Color) {
            this.width = width;
            this.height = height;
            this.fill_Color = fill_Color;
        }
    }

    public class RobotWorld extends JPanel {

        public RobotModel model;
        private PlayField playField;

        private Timer timer;

        public RobotWorld(PlayField playField, RobotModel robot_Model) {
            super();
            this.model = robot_Model;
            this.playField = playField;

            setBackground(playField.fill_Color);

            timer = new Timer(5, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Rectangle bounds = new Rectangle(new Point(0, 0), getSize());
                    for (Robot bot : model.bots) {
                        bot.move(bounds);
                    }
                    repaint();
                }
            });
        }

        public void start() {
            timer.start();
        }

        public void stop() {
            timer.stop();
        }

        @Override
        public Dimension getPreferredSize() {
            return playField == null ? super.getPreferredSize() : new Dimension(playField.width, playField.height);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            for (Robot bot : model.bots) {
                Graphics2D graphic = (Graphics2D) g.create();
                bot.paint(graphic);
                graphic.dispose();
            }
        }
    }

    public class Robot {

        public int x;
        public int y;
        public Color color;
        public final int speed = 10;
        public int size = 40;

        Robot(int x, int y, Color color) {
            this.x = x;
            this.y = y;
            this.color = color;
        }

        public void paint(Graphics2D g2d) {
            g2d.setColor(color);
            g2d.fillRect(x, y, size, size);
        }

        public void move_90() {
            this.y += speed;
        }

        public void move_270() {
            this.y -= speed;
        }

        public void move_180() {
            this.x += speed;
        }

        public void move_0() {
            this.x += speed;
        }

        public void move_45() {
            this.x += speed;
            this.y += speed;
        }

        public void move_135() {
            this.x -= speed;
            this.y += speed;
        }

        public void move_225() {
            this.x -= speed;
            this.y -= speed;
        }

        public void move_315() {
            this.x += speed;
            this.y -= speed;
        }

        public void move(Rectangle bounds) {
            Random temp = new Random();
            int rand = temp.nextInt(8);
            switch (rand) {
                case 1:
                    move_0();
                    break;
                case 2:
                    move_135();
                    break;
                case 3:
                    move_180();
                    break;
                case 4:
                    move_225();
                    break;
                case 5:
                    move_270();
                    break;
                case 6:
                    move_315();
                    break;
                case 7:
                    move_45();
                    break;
                case 8:
                    move_90();
                    break;
            }

            if (x < bounds.x) {
                x = bounds.x;
            } else if (x + size > bounds.x + bounds.width) {
                x = bounds.x + bounds.width - size;
            }
            if (y < bounds.y) {
                y = bounds.y;
            } else if (y + size > bounds.y + bounds.height) {
                y = bounds.y + bounds.height - size;
            }
        }

    }
}