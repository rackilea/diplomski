package javaapplication6;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.JFrame;

public class Beginner extends JFrame {

    Random rand = new Random();

    int n = 10;

    static List<Point> points = new ArrayList<Point>();

    public Beginner() {

        int radius = 200;
        Point center = new Point(250, 250);
        double angle = Math.toRadians(360 / n);
        points.add(center);

        for (int i = 0; i < n; i++) {
            double theta = i * angle;
            int dx = (int) (radius * Math.sin(theta));
            int dy = (int) (radius * Math.cos(theta));
            Point p = new Point(center.x + dx, center.y + dy);
            points.add(p);

        }
        draw(points);
    }

    public void draw(List<Point> points) {
        JPanel panels = new JPanel();
        SpringLayout spring = new SpringLayout();

        int count = 1;
        for (Point point : points) {

            JButton quest = new JButton("Question " + count);

            quest.setForeground(Color.BLACK);
            Font fonte = new Font("Script MT Bold", Font.PLAIN, 20);
            quest.setFont(fonte);
            quest.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent et) {
                    System.out.println(quest.getText());
                    //do something else
                }

            });
            add(quest);

            spring.putConstraint(SpringLayout.WEST, quest, point.x, SpringLayout.WEST, panels);

            spring.putConstraint(SpringLayout.NORTH, quest, point.y, SpringLayout.NORTH, panels);

            setLayout(spring);

            panels.setOpaque(false);
            panels.setVisible(true);
            panels.setLocation(5, 5);

            add(panels);

            count++;
        }
        setSize(700, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Beginner();
    }
}