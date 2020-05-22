// Class RefreshTree.java:

import javax.swing.*;
import javax.swing.tree.*;

public class RefreshTree {
    public static final String ADD_EMPLOYEE = "Add Employee";
    public static final String REMOVE_EMPLOYEE = "Remove Employee";

    public static void main(final String[] arguments) {
        new RefreshTree().launchGui();
    }

    private void launchGui() {
        final DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("root");
        rootNode.add(new DefaultMutableTreeNode(ADD_EMPLOYEE));
        rootNode.add(new DefaultMutableTreeNode(ADD_EMPLOYEE));
        rootNode.add(new DefaultMutableTreeNode(ADD_EMPLOYEE));

        final JTree tree = new JTree(rootNode);
        tree.setEditable(true);
        tree.setCellRenderer(new ButtonCellRenderer());
        tree.setCellEditor(new ButtonCellEditor());

        final JFrame frame = new JFrame("Refresh JTree with JButton");
        frame.getContentPane().add(new JScrollPane(tree));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(400, 200, 600, 600);
        frame.setVisible(true);
    }
}


// Class ButtonCellEditor.java:

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class ButtonCellEditor extends AbstractCellEditor implements TreeCellEditor {
    private JButton button;

    public ButtonCellEditor() {
        button = new JButton(RefreshTree.ADD_EMPLOYEE);
        button.addActionListener(actionEvent -> {
            final boolean add = RefreshTree.ADD_EMPLOYEE.equals(button.getText());
            if (add)
                System.out.println("Call addEmp(eb.point)");
            else
                System.out.println("Call delEmployee(eb.point)");
            button.setText(add ? RefreshTree.REMOVE_EMPLOYEE : RefreshTree.ADD_EMPLOYEE);
            stopCellEditing();
        });
    }

    @Override
    public Object getCellEditorValue() {
        return button.getText();
    }

    @Override
    public Component getTreeCellEditorComponent(final JTree tree,
                                                final Object value,
                                                final boolean isSelected,
                                                final boolean expanded,
                                                final boolean leaf,
                                                final int row) {
        button.setText(value.toString());
        return button;
    }
}


// Class ButtonCellRenderer.java:

import java.awt.*;
import javax.swing.*;
import javax.swing.tree.*;

public class ButtonCellRenderer extends JButton implements TreeCellRenderer {
    @Override
    public Component getTreeCellRendererComponent(final JTree tree,
                                                  final Object value,
                                                  final boolean selected,
                                                  final boolean expanded,
                                                  final boolean leaf,
                                                  final int row,
                                                  final boolean hasFocus) {
        setText(value.toString());
        return this;
    }
}