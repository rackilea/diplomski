import javax.swing.*;
import javax.swing.text.html.HTMLEditorKit;
import java.awt.*;

public class JavaBug extends javax.swing.JFrame {

    public static void main(String[] args) {
        JavaBug frame = new JavaBug();
        frame.show();
    }

    public JavaBug() {
        JTextPane textPane = new JTextPane();
        textPane.setEditorKit(new HTMLEditorKit());
        textPane.setText("<html><font size='+2'>\u0635\u0646\u062F\u0648\u0642 \u06F4\u06F0×\u06F3\u06F0 \u067E\u0627\u06CC\u0647 \u062F\u0627\u0631 \u0648\u0627\u06CC\u0631\u0646\u06AF \u0645\u06CC\u062A\u0631 \u062A\u06A9 \u0641\u0627\u0632</font></html>");
        textPane.getDocument().putProperty("i18n", Boolean.TRUE);
        JPanel noWrapPanel = new JPanel( new BorderLayout() );
        noWrapPanel.add( textPane );
        JScrollPane scrollPane = new JScrollPane( noWrapPanel );
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        /* without below right to left force there is an other bug when we press home and
         * try to navigate to end using left key it will never get at end and fall back at start. kind of crazy bug */
        java.util.Locale arabic = new java.util.Locale("ar", "KW");
        ComponentOrientation arabicOrientation = ComponentOrientation.getOrientation(arabic);
        textPane.applyComponentOrientation(arabicOrientation);

        getContentPane().add(scrollPane);
        pack();
        this.setLocationRelativeTo(null); //enusre get showed at screen center
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    }
}