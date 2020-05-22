package com.ggl.triangle;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TriangleFrame extends JFrame {

    private static final long serialVersionUID = -4599398094173430071L;

    public TriangleFrame() {
        init();
    }

    private void init() {
        this.setTitle("Draggable triangles. Click one and drag "
                + "it with the mouse.");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        TrianglePanel panel = new TrianglePanel();
        this.add(panel);
        pack();
    }

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                TriangleFrame frame = new TriangleFrame();
                frame.setVisible(true);
            }

        };

        SwingUtilities.invokeLater(runnable);
    }
}