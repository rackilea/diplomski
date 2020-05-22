import javax.swing.*;
import java.awt.*;

public class BiogramTable extends JFrame {

    public BiogramTable() {

        JTable selectionTable = new JTable(
                new Object[][]{
                    { true, "Foo" },
                    { false, "Bar"}
                },
                new Object[]{"Select", "Biagrams"}
        );

        JScrollPane scroll = new JScrollPane(selectionTable);
        getContentPane().add(scroll, BorderLayout.CENTER);

        JProgressBar bar = new JProgressBar(0, 10);
        bar.setStringPainted(true);
        getContentPane().add(bar, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] arg) {
        new BiogramTable();
    }
}