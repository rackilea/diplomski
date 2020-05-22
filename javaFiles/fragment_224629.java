import javax.swing.JInternalFrame;

public class WeatherIFrame extends JInternalFrame {

    public WeatherIFrame() {
        this.setTitle("Weather");
        this.setSize(300, 200);
        this.setVisible(true);
        this.setClosable(true);
        this.setResizable(true);        
    }
}