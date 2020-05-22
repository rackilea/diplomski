import java.awt.Container;

import javax.swing.JFrame;

public class ImageRotation {

    public static void main(String[] args) {
        // The route of the image and the degrees of rotation
        String route = "C:\\Users\\Public\\Pictures\\Sample Pictures\\download.jpg";
        double degrees = 30;
        // Frame to display the image
        JFrame jf = new JFrame("Image Rotated");
        // Introduce the route and degrees
        Rotate tl = new Rotate(route, degrees);
        // Set the size of the frame
        int hyp = (int) tl.getDiagonal();
        jf.setSize(hyp, hyp);
        // Print the rotated image in the frame
        Container cp = jf.getContentPane();
        cp.add(tl);
        // Display
        jf.setVisible(true);
    }
}