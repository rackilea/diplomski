package com.turtle.main;

import java.awt.Color;
import ch.aplu.turtle.Turtle;

public class TurtleMain {

    public static void main(String[] args) {

        Turtle turtle = new Turtle();

        // Init config
        turtle.setColor(Color.RED);
        turtle.setPenColor(Color.BLUE);
        turtle.setFillColor(Color.GREEN);

        // Draw rectangle
        for (int count = 0; count < 4; count++) {
            turtle.fd(100);
            turtle.right(90);
        }

        // Fill rectangle
        turtle.fill(1, 1);
    }
}