import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.util.LinkedList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.jdesktop.swingx.MultiSplitPane;
import org.jdesktop.swingx.MultiSplitLayout.*;

@SuppressWarnings("serial")
class MultiSplitPaneTest extends JFrame {
    private final static String sampleText;

    static {
        String text = "I'm working on a text editor in which the user is free to divide the editor window vertically or horizontally any number of times (ie, into any number of panes).\n";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            sb.append(text);
        }
        sampleText = sb.toString();
    }

    private class MyScrollPane extends JScrollPane {
        public MyScrollPane(final Component view) {
            super(view);
        }
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1440, 900);
        }
    }

    public MultiSplitPaneTest() {
        // The application opens with a window containing a single pane (a single text area).

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JTextArea ta1 = new JTextArea();
        ta1.setText("TEXT AREA 1\n" + sampleText);

        MyScrollPane sp1 = new MyScrollPane(ta1);
        sp1.setViewportView(ta1);

        cp.add(sp1, BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        // -------------------------------------------------

        // Let's say the user splits the window horizontally, creating a second pane.
        // We'll simulate that with the following code.

        JTextArea ta2 = new JTextArea();
        ta2.setText("TEXT AREA 2\n" + sampleText);

        MyScrollPane sp2 = new MyScrollPane(ta2);
        sp2.setViewportView(ta2);

        Leaf leaf1 = new Leaf("1");
        Leaf leaf2 = new Leaf("2");

        LinkedList<Node> rootChildren = new LinkedList<>();
        rootChildren.add(leaf1);
        rootChildren.add(new Divider());
        rootChildren.add(leaf2);

        Split root = new Split();
        root.setRowLayout(true);
        root.setChildren(rootChildren);

        MultiSplitPane multiSplitPane = new MultiSplitPane();
        multiSplitPane.getMultiSplitLayout().setModel(root);

        multiSplitPane.add(sp1, "1");
        multiSplitPane.add(sp2, "2");

        cp.remove(sp1);
        cp.add(multiSplitPane, BorderLayout.CENTER);

        // --------------------------------------------------

        // Let's say the user splits the window horizontally again, creating a new pane on the very left.

        JTextArea ta3 = new JTextArea();
        ta3.setText("TEXT AREA 3\n" + sampleText);

        MyScrollPane sp3 = new MyScrollPane(ta3);
        sp3.setViewportView(ta3);

        Leaf leaf3 = new Leaf("3");

        rootChildren.add(0, leaf3);
        rootChildren.add(1, new Divider());

        root.setChildren(rootChildren);

        multiSplitPane.add(sp3, "3");

        multiSplitPane.revalidate();

        // --------------------------------------------------

        // Let's say the user decides to remove the center pane (that is, the first pane that we started with).

        rootChildren.remove(2); // Remove leaf1.
        rootChildren.remove(2); // Remove the divider following leaf1.

        root.setChildren(rootChildren);

        multiSplitPane.remove(sp1);

        multiSplitPane.revalidate();

        // --------------------------------------------------

        // Let's say the user creates another pane, this time splitting the pane on the right vertically.

        rootChildren.remove(leaf2);

        JTextArea ta4 = new JTextArea();
        ta4.setText("TEXT AREA 4\n" + sampleText);

        MyScrollPane sp4 = new MyScrollPane(ta4);
        sp4.setViewportView(ta4);

        Leaf leaf4 = new Leaf("4");

        LinkedList<Node> branchChildren = new LinkedList<>();
        branchChildren.add(leaf2);
        branchChildren.add(new Divider());
        branchChildren.add(leaf4);

        Split branch = new Split();
        branch.setRowLayout(false);
        branch.setChildren(branchChildren);

        rootChildren.add(branch);

        root.setChildren(rootChildren);

        multiSplitPane.add(sp4, "4");

        multiSplitPane.revalidate();
    }
}