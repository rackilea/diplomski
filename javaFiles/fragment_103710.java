import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewWithMemoryImages extends Application
{
    private static String IMAGE_IN_MEMORY;

    @Override
    public void start(Stage primaryStage)
    {
        WebView webView = new WebView();
        webView.getEngine().loadContent("<html><body><img src=\"" + IMAGE_IN_MEMORY + "\"></body></html>");
        primaryStage.setScene(new Scene(webView, 420, 420));
        primaryStage.show();
    }

    public static void main(String[] args) throws Exception
    {
        BufferedImage image = new BufferedImage(400, 400, BufferedImage.TYPE_INT_BGR);
        Graphics2D g = image.createGraphics();
        try
        {
            g.setColor(Color.RED);
            g.fillRect(0, 0, 400, 400);
            g.setColor(Color.WHITE);
            g.fillRect(50, 50, 300, 300);
            g.setColor(Color.BLACK);
            g.fillRect(100, 100, 200, 200);
            g.drawString("No image files were used in this WebView.", 90, 70);
        }
        finally
        {
            g.dispose();
        }
        IMAGE_IN_MEMORY = getImageSrcForWebEngine(image);

        launch(args);
    }

    public static String getImageSrcForWebEngine(RenderedImage image) throws IIOException, IOException
    {
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", output);
        return "data:base64," + Base64.getMimeEncoder().encodeToString(output.toByteArray());
    }
}