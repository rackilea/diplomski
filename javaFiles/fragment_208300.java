import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.UIManager;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

public class TestCustomTreeNode {

    public static void main(String args[]) {
        new TestCustomTreeNode();
    }
    private JPopupMenu pm;

    public TestCustomTreeNode() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                pm = new JPopupMenu();
                pm.add(new JLabel("Suprise"));

                JFrame f = new JFrame("JTree Sample");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                JPanel pnlMain = new JPanel(new BorderLayout());
                pnlMain.setBackground(Color.white);

                createTree(pnlMain);

                f.setContentPane(new JScrollPane(pnlMain));

                f.setSize(300, 200);
                f.setVisible(true);
            }
        });
    }

    private void createTree(JPanel pnlMain) {
        Employee bigBoss = new Employee(Employee.randomName(), true);
        Employee[] level1 = new Employee[5];
        bigBoss.employees = level1;

        for (int i = 0; i < level1.length; i++) {
            level1[i] = new Employee(Employee.randomName(), true);
        }


        for (int i = 0; i < level1.length; i++) {
            Employee employee = level1[i];
            if (employee.isBoss) {
                int count = 5;
                employee.employees = new Employee[count];

                for (int j = 0; j < employee.employees.length; j++) {
                    employee.employees[j] = new Employee(Employee.randomName(), false);
                }
            }
        }

        CustomTreeNode root = new CustomTreeNode(loadResource("/pirate.png"), bigBoss);
        root.setUserObject("Root");
        DefaultTreeModel model = new DefaultTreeModel(root);

        for (Employee employee : bigBoss.employees) {
            CustomTreeNode boss = new CustomTreeNode(loadResource("/angel.png"), employee);
            root.add(boss);
            if (employee.isBoss) {
                for (Employee employee1 : employee.employees) {
                    CustomTreeNode emp = new CustomTreeNode(loadResource("/devil.png"), employee1);
                    boss.add(emp);
                }
            }
        }

        JTree tree = new JTree(model);
        tree.setCellRenderer(new CustomeTreeCellRenderer());
        pnlMain.add(tree, BorderLayout.CENTER);

        tree.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.isPopupTrigger()) {
                    pm.show(e.getComponent(), e.getX(), e.getY());
                }
            }
        });

    }

    protected ImageIcon loadResource(String name) {

        ImageIcon image = null;
        try {
            image = new ImageIcon(ImageIO.read(getClass().getResource(name)));
            System.out.println(name + " - " + image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return image;

    }

    public static class Employee {

        public String name;
        public int id;
        public boolean isBoss;
        public Employee[] employees;

        public Employee(String name, boolean isBoss) {
            this.name = name;
            this.isBoss = isBoss;
            this.id = new Random(System.currentTimeMillis()).nextInt(Integer.MAX_VALUE);
        }

        @Override
        public String toString() {
            return this.name;
        }

        static String randomName() {
            String chars = "abcdefghijklmnopqrstuvwxyz";
            StringBuilder builder = new StringBuilder();
            Random r = new Random(System.currentTimeMillis());
            int length = r.nextInt(10) + 1;
            for (int i = 0; i < length; i++) {
                builder.append(chars.charAt(r.nextInt(chars.length())));
            }

            return builder.toString();
        }
    }

    public class CustomTreeNode extends DefaultMutableTreeNode {

        /**
         * The icon which is displayed on the JTree object. open, close, leaf icon.
         */
        private ImageIcon icon;

        public CustomTreeNode(ImageIcon icon) {
            this.icon = icon;
        }

        public CustomTreeNode(ImageIcon icon, Object userObject) {
            super(userObject);
            this.icon = icon;
        }

        public CustomTreeNode(ImageIcon icon, Object userObject, boolean allowsChildren) {
            super(userObject, allowsChildren);
            this.icon = icon;
        }

        public ImageIcon getIcon() {
            return icon;
        }

        public void setIcon(ImageIcon icon) {
            this.icon = icon;
        }
    }

    class CustomeTreeCellRenderer extends DefaultTreeCellRenderer {

        public CustomeTreeCellRenderer() {
        }

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {

//            if (!leaf) {
            CustomTreeNode node = (CustomTreeNode) value;

            if (node.getIcon() != null) {
                System.out.println(node + " - " + node.getIcon());
                setClosedIcon(node.getIcon());
                setOpenIcon(node.getIcon());
                setLeafIcon(node.getIcon());
            } else {
                System.out.println(node + " - default");
                setClosedIcon(getDefaultClosedIcon());
                setLeafIcon(getDefaultLeafIcon());
                setOpenIcon(getDefaultOpenIcon());
            }
//            }

            super.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);

            return this;
        }
    }
}