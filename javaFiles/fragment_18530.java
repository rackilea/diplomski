import javafx.geometry.Bounds;
import javafx.scene.text.Text;
import javafx.scene.text.TextBuilder;
import javafx.stage.Stage;
import javafx.scene.text.Font;

public class stack extends javafx.application.Application {

    public static void main(String[] args)
    {
        // Builder
        Bounds b = TextBuilder.create().text("hello").build().getLayoutBounds();
        System.out.println(b.getHeight() + ", " + b.getWidth());

        b = TextBuilder.create().text("heeeeello").build().getLayoutBounds();
        System.out.println(b.getHeight() + ", " + b.getWidth());

        // No builder
        b = new Text("hello").getLayoutBounds();
        System.out.println(b.getHeight() + ", " + b.getWidth());

        b = new Text("heeeeello").getLayoutBounds();
        System.out.println(b.getHeight() + ", " + b.getWidth());

        // With bad font, zero sized
        Font my_font = new Font("i am not a font", 0);
        Text text = new Text("heeeeello");
        text.setFont(my_font);
        b = text.getLayoutBounds();
        System.out.println(b.getHeight() + ", " + b.getWidth());

        // With bad font, arbitrary size
        my_font = new Font("i am not a font", 20);
        text = new Text("heeeeello");
        text.setFont(my_font);
        b = text.getLayoutBounds();
        System.out.println(b.getHeight() + ", " + b.getWidth());
    }

    @Override
    public void start(Stage primaryStage) throws Exception {  }  
}