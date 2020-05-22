import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Universe extends JPanel {

private int screenW;
private int screenH;
private int[][] points2D;

private double[] center;
private double[][] points3D;

private Camera camera;  

public Universe() {

    screenW = 864;
    screenH = 576;

    setPreferredSize(new Dimension(screenW, screenH));

    points2D = new int[8][2];

    center = new double[] {0, 0, 0};

    // Initialize the camera object with "placeholder" values, just to
    // reserve space in memory for two suitably sized arrays
    double[] initpos = new double[] {0, 0, 10};
    double[][] initrot = new double[][] {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};
    camera = new Camera(initpos, initrot);

    points3D = new double[][] {{1, 1, 1},
                                {1, 1, -1},
                                {1, -1, 1},
                                {1, -1, -1},
                                {-1, 1, 1},
                                {-1, 1, -1},
                                {-1, -1, 1},
                                {-1, -1, -1}};
}

public void paint(Graphics g) {

    g.setColor(new Color(0, 0, 0));
    g.fillRect(0, 0, screenW, screenH);

    g.setColor(new Color(255, 255, 255));
    g.drawLine(points2D[0][0], points2D[0][1], points2D[1][0], points2D[1][1]);
    g.drawLine(points2D[2][0], points2D[2][1], points2D[3][0], points2D[3][1]);
    g.drawLine(points2D[4][0], points2D[4][1], points2D[5][0], points2D[5][1]);
    g.drawLine(points2D[6][0], points2D[6][1], points2D[7][0], points2D[7][1]);
    g.drawLine(points2D[1][0], points2D[1][1], points2D[5][0], points2D[5][1]);
    g.drawLine(points2D[0][0], points2D[0][1], points2D[4][0], points2D[4][1]);
    g.drawLine(points2D[3][0], points2D[3][1], points2D[7][0], points2D[7][1]);
    g.drawLine(points2D[2][0], points2D[2][1], points2D[6][0], points2D[6][1]);
    g.drawLine(points2D[0][0], points2D[0][1], points2D[2][0], points2D[2][1]);
    g.drawLine(points2D[1][0], points2D[1][1], points2D[3][0], points2D[3][1]);
    g.drawLine(points2D[5][0], points2D[5][1], points2D[7][0], points2D[7][1]);
    g.drawLine(points2D[4][0], points2D[4][1], points2D[6][0], points2D[6][1]);
}

public void loop() {

    double t = 0;
    double dt = 0.02;

    while(true) {

        try {
            Thread.sleep(50);
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }

        camera.position[0] =  10 * Math.sin(t % (2 * Math.PI));
        camera.position[1] =   0;
        camera.position[2] =  10 * Math.cos(t % (2 * Math.PI));

        // The x unit vector of the camera plane coordinate frame, expressed
        // in the cube's coordinate frame
        camera.rotation[0][0] = Math.cos(t % (2 * Math.PI));
        camera.rotation[0][1] = 0;
        camera.rotation[0][2] = -Math.sin(t % (2 * Math.PI));
        // The y unit vector of the camera plane coordinate frame, expressed
        // in the cube's coordinate frame
        camera.rotation[1][0] = 0; 
        camera.rotation[1][1] = 1;
        camera.rotation[1][2] = 0;
        // Ditto, z unit vector
        camera.rotation[2][0] = Math.sin(t % (2 * Math.PI));
        camera.rotation[2][1] = 0;
        camera.rotation[2][2] = Math.cos(t % (2 * Math.PI));

        project(points3D, points2D);

        repaint();
        t += dt;
    }
}

private void project(double[][] points3D, int[][] points2D) {;

    for(int i = 0; i < points3D.length; i++) {

        double[] camToPoint = new double[3];
        double[] rotPoint   = new double[3];

        // You may visualize this operation as "shifting" the vertices of the
        // cube to some new translational offset within an unrotated camera
        // coordinate frame.
        for(int j = 0; j < 3; j++) {
            camToPoint[j]  = points3D[i][j] - camera.position[j];
        }

        // Picture this operation as "rotating" the camera by the correct
        // amount so that it will always be facing the cube, no matter what
        // the current absolute position of the camera is within the cube's
        // coordinate frame.  If you don't do this, then the cube will pan
        // across your view and back around behind the camera much like the
        // sun rotating through the sky over the course of one complete day/
        // night cycle.
        rotPoint = new double[] {0, 0, 0};
        for(int j = 0; j< 3; j++) {
            for(int k = 0; k < 3; k++) {
                rotPoint[j] += camera.rotation[j][k] * camToPoint[k];
            }
        }

        // Project the cube onto the camera plane.
        points2D[i][0] = (int) (screenW * (0.5 * camera.frame[0] +
                            camera.focalLength * rotPoint[0] /
                            rotPoint[2]) / camera.frame[0]);
        points2D[i][1] = (int) (screenH * (0.5 * camera.frame[1] +
                            camera.focalLength * rotPoint[1] /
                            rotPoint[2]) / camera.frame[1]);
    }
}
}