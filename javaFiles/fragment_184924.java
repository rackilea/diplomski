public class ExampleClass {

    public static void main(String[] args) {
        new ExampleClass();
    }

    public ExampleClass() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                BrowserPane browserPane = new BrowserPane();
                CreateNewTabAction createNewTabAction = new CreateNewTabAction(browserPane);

                JMenu mnu = new JMenu("Stuff");
                mnu.add(createNewTabAction);

                JMenuBar mb = new JMenuBar();
                mb.add(mnu);

                JToolBar tb = new JToolBar();
                tb.add(createNewTabAction);

                JFrame frame = new JFrame();
                frame.setJMenuBar(mb);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(browserPane);
                frame.add(tb, BorderLayout.NORTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public interface TabController {

        public void createNewTab();
    }

    public class BrowserPane extends JPanel implements TabController {

        private TabbedBrowserPaneComponent cTabbedBrowserPane;

        public BrowserPane() {
            setLayout(new BorderLayout());
            // Set up Components
            this.cTabbedBrowserPane = new TabbedBrowserPaneComponent();
            add(cTabbedBrowserPane);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        @Override
        public void createNewTab() {

            cTabbedBrowserPane.createNewTab();

        }
    }

    public class TabbedBrowserPaneComponent extends JTabbedPane {

        public TabbedBrowserPaneComponent() {
            super();
            createNewTab();
        }

        public void createNewTab() {
            JPanel panel = new JPanel(new BorderLayout());
            panel.add(new JScrollPane(), BorderLayout.CENTER);
            this.addTab("Tab " + this.getTabCount(), panel);
        }
    }

    public class CreateNewTabAction extends AbstractAction {

        private TabController controller;

        public CreateNewTabAction(TabController controller) {
            super();
            this.controller = controller;
            putValue(Action.NAME, "New Tab");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            getController().createNewTab();
        }

        /**
         * @return the parent
         */
        public TabController getController() {
            return controller;
        }
    }
}