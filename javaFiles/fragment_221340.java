import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import static java.awt.print.Printable.NO_SUCH_PAGE;
import static java.awt.print.Printable.PAGE_EXISTS;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javax.imageio.ImageIO;

/**
 *
 * @author blj0011
 */
public class JavaFXApplication61 extends Application
{

    @Override
    public void start(Stage primaryStage)
    {
        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList("A", "B", "C", "D");
        list.setItems(items);

        VBox root = new VBox();

        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction((event) ->
        {
            WritableImage image = list.snapshot(new SnapshotParameters(), null);
            File file = new File("nodeImage.png");

            try
            {
                ImageIO.write(SwingFXUtils.fromFXImage(image, null), "png", file);

                Image imageToPrint = new Image(file.toURI().toString());
                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(imageToPrint, null);
                printImage(bufferedImage);
            }
            catch (IOException ex)
            {
                System.out.println(ex.toString());
            }
        });

        root.getChildren().add(btn);
        root.getChildren().add(list);
        Scene scene = new Scene(root, 1080, 720);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        launch(args);
    }

    private void printImage(BufferedImage image)
    {
        PrinterJob printJob = PrinterJob.getPrinterJob();
        printJob.setPrintable((Graphics graphics, PageFormat pageFormat, int pageIndex) ->
        {
            // Get the upper left corner that it printable
            int x = (int) Math.ceil(pageFormat.getImageableX());
            int y = (int) Math.ceil(pageFormat.getImageableY());
            if (pageIndex != 0)
            {
                return NO_SUCH_PAGE;
            }
            graphics.drawImage(image, x, y, image.getWidth(), image.getHeight(), null);
            return PAGE_EXISTS;
        });
        try
        {
            printJob.print();
        }
        catch (PrinterException e1)
        {
            e1.printStackTrace();
        }
    }
}