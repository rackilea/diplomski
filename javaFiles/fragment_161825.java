import java.awt.Dimension;
import java.awt.event.HierarchyEvent;
import java.awt.event.HierarchyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Editor extends JFrame {
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        new Editor();
    }

    private JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    private JTextArea guiEdit = new JTextArea();
    private JScrollPane utilScrollbar = new JScrollPane(guiEdit);
    private JTabbedPane guiOverviewTabPanel = new JTabbedPane();
    private JPanel guiOverviewTabIncludes = new JPanel();
    private JPanel guiOverviewTabFunctions = new JPanel();

    public Editor() {
        HierarchyListener hierarchyListener = new HierarchyListener() {
            @Override
            public void hierarchyChanged(HierarchyEvent event) {
                long flags = event.getChangeFlags();
                if ((flags & HierarchyEvent.SHOWING_CHANGED) == 
                        HierarchyEvent.SHOWING_CHANGED) {
                    splitPane.setDividerLocation(0.50D);
                }
            }

        };

//      guiEdit.setLineWrap(true);
//      guiEdit.setWrapStyleWord(true);

        splitPane.setLeftComponent(utilScrollbar);

        // Add tabs to the JTabbedPane
        guiOverviewTabPanel.add("Includes", guiOverviewTabIncludes);
        guiOverviewTabPanel.add("Functions", guiOverviewTabFunctions);

        splitPane.setRightComponent(guiOverviewTabPanel);

        splitPane.addHierarchyListener(hierarchyListener);
        add(splitPane);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(800, 400));

        setVisible(true);
    }
}