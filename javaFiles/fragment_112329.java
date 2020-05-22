import com.bc.ceres.core.ProgressMonitor;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.esa.beam.framework.dataio.ProductIO;
import org.esa.beam.framework.datamodel.Band;
import org.esa.beam.framework.datamodel.ImageInfo;
import org.esa.beam.framework.datamodel.MapGeoCoding;
import org.esa.beam.framework.datamodel.Product;
import org.esa.beam.util.ProductUtils;

public static void main(String[] args) throws IOException {

    String inputProductPath = "path\to\input\product";
    String outputProductPath = "path\to\output\image";

    // Read the source product.
    Product inputProduct = ProductIO.readProduct(inputProductPath);

    // Extract the RGB bands.
    String[] bandNames = new String[3];
    Band[] bandData = new Band[3];

    bandNames[0] = "radiance_3";
    bandNames[1] = "radiance_2";
    bandNames[2] = "radiance_1";

    for (Band band : inputProduct.getBands()) {

        for (int i = 0; i < bandNames.length; i++) {

            if (band.getName().equalsIgnoreCase(bandNames[ i ])) {
                bandData[ i ] = band;
            }
        }
    }

    // Generate quicklook image.
    ImageInfo outImageInfo = ProductUtils.createImageInfo(bandData, true, ProgressMonitor.NULL);
    BufferedImage outImage = ProductUtils.createRgbImage(bandData, outImageInfo, ProgressMonitor.NULL);
    outImage = resize(outImage, WIDTH, 1200);

    // Extract the orientation.
    double orientation;
    if (inputProduct.getGeoCoding() != null) {
        orientation = -((MapGeoCoding) inputProduct.getGeoCoding()).getMapInfo().getOrientation();
    } else {
        orientation = 0.0;
    }
    outImage = rotate(outImage, orientation);

    // Write image.
    ImageIO.write(outImage, "PNG", new File(outputProductPath));
}