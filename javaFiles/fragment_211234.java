import java.awt.Rectangle;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hslf.usermodel.HSLFSlide;
import org.apache.poi.hslf.usermodel.HSLFSlideShow;
import org.apache.poi.hslf.usermodel.HSLFTextBox;
import org.apache.poi.hslf.usermodel.HSLFTextRun;

public class BulletTest {
    public static void main(String[] args) throws IOException {
        HSLFSlideShow ppt = new HSLFSlideShow();
        HSLFSlide slide = ppt.createSlide();
        HSLFTextBox tb = slide.createTextBox();
        tb.setAnchor(new Rectangle(100, 100, 200, 200));

        HSLFTextRun titleTR = tb.appendText("Title", true);
        HSLFTextRun bullet1TR = tb.appendText(" bullet1", true);
        bullet1TR.getTextParagraph().setBullet(true);
        HSLFTextRun bullet2TR = tb.appendText(" bullet2", true);
        bullet2TR.getTextParagraph().setBullet(true);

        FileOutputStream fos = new FileOutputStream("bullet.ppt");
        ppt.write(fos);
        fos.close();
        ppt.close();
    }
}