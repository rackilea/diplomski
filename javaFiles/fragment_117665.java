import java.awt.BorderLayout;
            import java.awt.Color;
            import java.awt.Component;
            import java.awt.Dimension;
            import java.awt.GridLayout;

            import javax.swing.BorderFactory;
            import javax.swing.JButton;
            import javax.swing.JFrame;
            import javax.swing.JLabel;
            import javax.swing.JPanel;
            import javax.swing.JScrollPane;
            import javax.swing.JTextField;
            import javax.swing.JTree;
            import javax.swing.SwingConstants;
            import javax.swing.SwingUtilities;
            import javax.swing.WindowConstants;

            public class FrameDemo extends JFrame {
                private static final long serialVersionUID = 1L;

                public FrameDemo() {
                    super("Frame Demo");
                    setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                    getContentPane().add(new NorthPanel(), BorderLayout.NORTH);
                    getContentPane().add(new CenterPanel(), BorderLayout.CENTER);
                    getContentPane().add(new SouthPanel(), BorderLayout.SOUTH);

                //          Toolkit tk = Toolkit.getDefaultToolkit();
                //          int xSize = ((int) tk.getScreenSize().getWidth());
                //          int ySize = ((int) tk.getScreenSize().getHeight());
                //          setSize(xSize,ySize);

                    pack();
                    setLocationRelativeTo(null);
                }

                public static void main(String[] args) {
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            JFrame frame = new FrameDemo();
                            frame.setVisible(true);
                        }
                    });
                } 
            }

            class NorthPanel extends JPanel {
                private static final long serialVersionUID = 1L;

                public NorthPanel() {
                    super(new BorderLayout());
                    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    add(getHeaderPanel(), BorderLayout.NORTH);
                    add(getButtonPanel(), BorderLayout.SOUTH);
                }

                private Component getHeaderPanel() {
                    JPanel panel = new JPanel(new GridLayout(2, 1));
                    panel.setBackground(Color.WHITE);

                    panel.add(new JLabel("XXXXXX Enterprises", SwingConstants.CENTER));
                    panel.add(new JLabel("XXX, Industria; Area - II, XXXXXXXXX", SwingConstants.CENTER));

                    return panel;
                }

                private Component getButtonPanel() {
                    JPanel panel = new JPanel(new BorderLayout());
                    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));

                    JPanel buttons = new JPanel(new GridLayout(1, 2));
                    buttons.add(new JButton("Admin"));
                    buttons.add(new JButton("Exit"));

                    panel.add(buttons, BorderLayout.EAST);
                    return panel;
                }
            }

            class CenterPanel extends JPanel {
                private static final long serialVersionUID = 1L;

                private static final Dimension PANEL_SIZE = new Dimension(640, 480);

                public CenterPanel() {
                    super(new BorderLayout());
                    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    add(getSearchFieldsPanel(), BorderLayout.NORTH);
                    add(getResultsPanel(), BorderLayout.CENTER);
                }

                private Component getSearchFieldsPanel() {
                    JPanel panel = new JPanel(new BorderLayout());
                    panel.setBackground(Color.WHITE);

                    panel.add(new JLabel("Sales Inventory", SwingConstants.CENTER), BorderLayout.NORTH);
                    panel.add(getFieldsPanel(), BorderLayout.CENTER);
                    panel.add(getButtonPanel(), BorderLayout.SOUTH);

                    return panel;
                }

                private Component getResultsPanel() {
                    JPanel panel = new JPanel(new BorderLayout());

                    panel.add(getHeaderPanel(), BorderLayout.NORTH);
                    panel.add(new JScrollPane(new JTree()), BorderLayout.CENTER);
                    panel.add(getAnotherButtonPanel(), BorderLayout.SOUTH);

                    return panel;
                }

                private Component getHeaderPanel() {
                    JPanel panel = new JPanel(new BorderLayout());
                    panel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));

                    JLabel label = new JLabel("Customers", SwingConstants.LEFT);
                    label.setOpaque(true);
                    label.setBackground(Color.WHITE);


                    panel.add(label, BorderLayout.NORTH);
                    return panel;
                }

                private Component getFieldsPanel() {
                    JPanel panel = new JPanel(new GridLayout(1, 4));

                    panel.add(new LabeledField("Name :  "));
                    panel.add(new LabeledField("Firm Name :  "));
                    panel.add(new LabeledField("City :  "));
                    panel.add(new LabeledField("Mobile :  "));

                    return panel;
                }

                private Component getButtonPanel() {
                    JPanel panel = new JPanel(new BorderLayout());
                    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
                    panel.setBackground(Color.WHITE);

                    JPanel buttons = new JPanel(new GridLayout(1, 2));
                    buttons.add(new JButton("Reset"));
                    buttons.add(new JButton("Search"));

                    panel.add(buttons, BorderLayout.EAST);
                    return panel;
                }

                private Component getAnotherButtonPanel() {
                    JPanel panel = new JPanel(new BorderLayout());
                    panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
                    panel.setBackground(Color.WHITE);

                    JPanel buttons = new JPanel(new GridLayout(1, 2));
                    buttons.add(new JButton("Next"));

                    panel.add(buttons, BorderLayout.EAST);
                    return panel;
                }

                public Dimension getPreferredSize() {
                    return PANEL_SIZE;
                }

                public Dimension getMinimumSize() {
                    return PANEL_SIZE;
                }

                public Dimension getMaximumSize() {
                    return PANEL_SIZE;
                }
            }

            class SouthPanel extends JPanel {
                private static final long serialVersionUID = 1L;

                public SouthPanel() {
                    super(new GridLayout());

                    setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

                    add(new JButton("Sales Inventory"));
                    add(new JButton("Customer"));
                    add(new JButton("Stock Inventory"));
                    add(new JButton("Reports"));
                }
            }

            class LabeledField extends JPanel {
                private static final long serialVersionUID = 1L;

                public LabeledField(String label) {
                    super(new BorderLayout());

                    setBackground(Color.WHITE);
                    add(getLabel(label), BorderLayout.WEST);
                    add(getEntry(), BorderLayout.CENTER);
                }

                private Component getLabel(String caption) {
                    JLabel label = new JLabel(caption, SwingConstants.RIGHT);
                    label.setPreferredSize(new Dimension(85, 25));
                    return label;
                }

                private Component getEntry() {
                    return new JTextField();
                }
            }