import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import org.imgscalr.Scalr;

public class App extends JFrame implements ActionListener{

        BufferedImage originalImage = null;
        BufferedImage temp = null;
        JFileChooser chooser = null;

        public App(){

                setVisible(true);
        }

        public static void main(String[] args) throws IOException, InterruptedException {


                SwingUtilities.invokeLater(
                                () -> {
                                        App app = new App();

                                        Timer timer = new Timer(1000, app);
                                        timer.start();

                                });

        }

        @Override
        public void actionPerformed(ActionEvent ae){
                if(null == chooser){
                        chooser = new JFileChooser();
                        chooser.showOpenDialog(this);
                        loadImage();
                }
                showImage();
                repaint();
        }

        @Override
        public void paint(Graphics g){
                super.paint(g);
                if(null == temp){
                        return;
                }
                g.drawImage(temp, 0, 0, null);
        }

        public void loadImage(){

                try{
                        originalImage = ImageIO.read(chooser.getSelectedFile());
                } catch(IOException ioe){
                        ioe.printStackTrace();
                }
        }

        public void showImage() {
                int width = (int) ((Math.random()*1000)+1); 
                int height = (int) ((Math.random()*1000)+1);
                temp = Scalr.resize(originalImage,Scalr.Mode.BEST_FIT_BOTH, width, height);
                setSize(width, height);
        }
}