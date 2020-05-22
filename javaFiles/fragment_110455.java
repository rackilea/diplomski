import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hslf.model.PPGraphics2D;
import org.apache.poi.hslf.model.Picture;
import org.apache.poi.hslf.model.ShapeGroup;
import org.apache.poi.hslf.model.Slide;
import org.apache.poi.hslf.usermodel.SlideShow;

public class PowerPointTest {

    public static void main( String[] args ) {

        SlideShow slideShow = new SlideShow();
        Slide slide = slideShow.createSlide();

        try {
            // Rectangle1 (partly hidden)
            fillRectangle( slide, Color.blue, 20, 20, 300, 300 );

            // Image
            int index = slideShow.addPicture(new File("IMG_8499.jpg"), Picture.JPEG);
            Picture picture = new Picture(index);
            picture.setAnchor(new Rectangle( 50, 50, 300, 200 ));
            slide.addShape(picture);

            // Rectangle2 (all visible)
            fillRectangle( slide, Color.yellow, 250, 150, 50, 10 );


            FileOutputStream out = new FileOutputStream( "z-order.ppt" );
            slideShow.write( out );
            out.close();
        } catch ( FileNotFoundException e ) {
            e.printStackTrace();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
    }

private static void fillRectangle( Slide slide, Color color, int x, int y, int width, int height ) {
        // Objects are drawn into a shape group, so we need to create one
        ShapeGroup group = new ShapeGroup();
        // Define position of the drawing inside the slide
        Rectangle bounds = new Rectangle(x, y, width, height);

        group.setAnchor(bounds);
        slide.addShape(group);

        // Drawing a rectangle
        Graphics2D graphics = new PPGraphics2D(group);
        graphics.setColor(color);
        graphics.fillRect(x, y, width, height); 
    }
}