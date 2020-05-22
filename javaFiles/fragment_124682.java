import java.nio.ByteBuffer;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class DirectImageFromArray extends Application {

    @Override
    public void start(Stage primaryStage) {
        final int width = 64 ;
        final int height = 32 ;

        final int boxSize = 8 ;

        final int blackArgb = 0xFF << 24 ;
        final int whiteArgb = 0xFF << 24 | 0xFF << 16 | 0xFF << 8 | 0xFF ;

        byte[] data = new byte[width*height];
        for (int y = 0 ; y < boxSize; y++) {
            int scanLineStride = y * width ;
            for (int x = 0 ; x < boxSize; x++) {
                data[x+scanLineStride] = 1 ;
            }
        }

        WritableImage img = new WritableImage(width, height);

        // indexed colors 0 -> black, 1 -> white:
        PixelFormat<ByteBuffer> pixelFormat = 
                PixelFormat.createByteIndexedInstance(new int[] {blackArgb, whiteArgb});

        // write entire image:
        img.getPixelWriter().setPixels(0, 0, width, height, pixelFormat, data, 0, width);

        // represents the first pixel that is white:
        IntegerProperty firstLitPixel = new SimpleIntegerProperty();

        // update the data array and then the image when the property changes:
        firstLitPixel.addListener((obs, oldValue, newValue) -> {

            // track portion that changes:
            int minChangedX = width ;
            int minChangedY = height ;
            int maxChangedX = 0 ;
            int maxChangedY = 0 ;

            // move box
            for (int y = 0; y < boxSize; y++) {

                // set left edge of box to black:
                int oldIndex = (oldValue.intValue() + y * width) % (width * height) ;
                data[oldIndex] = 0 ;

                // set right edge of new box location to white:
                int newIndex = (newValue.intValue() + y * width + boxSize - 1) % (width*height) ;
                data[newIndex] = 1 ;

                // update changed portion:
                int oldX = oldIndex % width ;
                int oldY = oldIndex / width ;
                int newX = newIndex % width ;
                int newY = newIndex / width ;
                minChangedX = Math.min(minChangedX, Math.min(oldX, newX));
                maxChangedX = Math.max(maxChangedX, Math.max(oldX, newX));
                minChangedY = Math.min(minChangedY, Math.min(oldY, newY));
                maxChangedY = Math.max(maxChangedY, Math.max(oldY, newY));
            }
            int minIndex = minChangedX + minChangedY * width ;
            int changedWidth = maxChangedX - minChangedX + 1;
            int changedHeight = maxChangedY - minChangedY + 1;

            // update image
            img.getPixelWriter().setPixels(minChangedX, minChangedY, 
                    changedWidth, changedHeight, 
                    pixelFormat, data, minIndex, width);
        });

        // animate the property:
        Timeline animation = new Timeline(new KeyFrame(Duration.millis(10), event -> 
            firstLitPixel.set((firstLitPixel.get() + 1) % (width * height))
        ));

        animation.setCycleCount(Animation.INDEFINITE);
        animation.play();

        ImageView imageView = new ImageView(img);
        StackPane root = new StackPane(imageView);
        Scene scene = new Scene(root, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}