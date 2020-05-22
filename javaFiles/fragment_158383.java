import javax.swing.*;
import javax.swing.text.*;

public class TabExample {

    public static void main(String[] args) {

        JTextPane pane = new JTextPane();
        TabStop[] tabs = new TabStop[4];
        tabs[0] = new TabStop(60, TabStop.ALIGN_RIGHT, TabStop.LEAD_NONE);
        tabs[1] = new TabStop(100, TabStop.ALIGN_LEFT, TabStop.LEAD_NONE);
        tabs[2] = new TabStop(200, TabStop.ALIGN_CENTER, TabStop.LEAD_NONE);
        tabs[3] = new TabStop(300, TabStop.ALIGN_DECIMAL, TabStop.LEAD_NONE);
        TabSet tabset = new TabSet(tabs);

        StyleContext sc = StyleContext.getDefaultStyleContext();
        AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY,
        StyleConstants.TabSet, tabset);
        pane.setParagraphAttributes(aset, false);
        pane.setText("\tright\tleft\tcenter\tdecimal\n" + "\t1\t1\t1\t1.0\n"
        + "\t200.002\t200.002\t200.002\t200.002\n"
        + "\t.33\t.33\t.33\t.33\n");

        JFrame frame = new JFrame("TabExample");
        frame.setContentPane(new JScrollPane(pane));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(360, 120);
        frame.setVisible(true);
    }
}