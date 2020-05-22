import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class PoorlySpecifiedLayout {

    // the GUI as seen by the user (without frame)
    JPanel ui = new JPanel(new BorderLayout(5,5));
    String[] comboValues = {
        "String to pad combo."
    };
    String[] tableHeader = {
        "Section Name","Report Name","Contact","Link"
    };
    String[][] tableBody = {{"", "", "", ""}};

    PoorlySpecifiedLayout() {
        initUI();
    }

    public final void initUI() {
        ui.setBorder(new EmptyBorder(20,20,20,20));

        JPanel top = new JPanel(new BorderLayout(15, 5));
        ui.add(top, BorderLayout.PAGE_START);

        top.add(new JLabel(
                "Fetching search results", SwingConstants.CENTER));
        JPanel controls = new JPanel(new FlowLayout(SwingConstants.LEADING, 10, 5));
        top.add(controls, BorderLayout.PAGE_END);
        controls.add(new JLabel("Search:"));
        controls.add(new JComboBox(comboValues));
        JButton submit = new JButton("submit");
        Insets padButton = new Insets(5,20,5,20);
        submit.setMargin(padButton);
        controls.add(submit);
        JTable table = new JTable(tableBody, tableHeader);
        ui.add(new JScrollPane(table));
    }

    public final JComponent getUI(){
        return ui;
    }

    public static void main(String[] args) {
        Runnable r = new Runnable() {

            @Override
            public void run() {
             PoorlySpecifiedLayout psl = new PoorlySpecifiedLayout();   

                JFrame f = new JFrame("Poorly Specified Layout");
                f.add(psl.getUI());
                // Ensures JVM closes after frame(s) closed and
                // all non-daemon threads are finished
                f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                // See http://stackoverflow.com/a/7143398/418556 for demo.
                f.setLocationByPlatform(true);

                // ensures the frame is the minimum size it needs to be
                // in order display the components within it
                f.pack();
                // should be done last, to avoid flickering, moving,
                // resizing artifacts.
                f.setVisible(true);
            }
        };
        // Swing GUIs should be created and updated on the EDT
        // http://docs.oracle.com/javase/tutorial/uiswing/concurrency
        SwingUtilities.invokeLater(r);
    }
}