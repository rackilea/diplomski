import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

public class Frame extends JFrame {
    public Generator g;

    public Frame(){
        setSize(400, 400);
        g = new Generator(2000, 2000);
        JScrollPane scrollPane = new JScrollPane(g);
        scrollPane.setPreferredSize(new Dimension(300,300));
        add(scrollPane);
        setVisible(true);
    }
}