import javax.swing.*;
import java.awt.*;

public class DetailsPanel extends JPanel {

    public DetailsPanel() {
        super();
        createGUI();
    }

    private void createGUI() {
        setBackground(Color.BLUE);
        setPreferredSize(new Dimension(200, 800));
        setVisible(false);
    }
}