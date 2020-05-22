public class BadLayout06 {

    public static void main(String[] args) {
        new BadLayout06();
    }

    public BadLayout06() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JMenuBar mb = new JMenuBar();
                mb.add(new JMenu("File"));

                JToolBar tb = new JToolBar();
                tb.add(new JButton("Zoom In"));
                tb.add(new JButton("Zoom Out"));
                tb.add(new JButton("Invert Image"));
                tb.add(new JButton("Toggle Highlights"));
                tb.add(new JButton("Save"));
                tb.add(new JButton("Cancel"));
                tb.setFloatable(false);

                JSplitPane spSub = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
                JTabbedPane tpLeft = new JTabbedPane();
                tpLeft.add("Table Entry", new JPanel());
                tpLeft.add("Form Entry", new JPanel());
                spSub.setLeftComponent(tpLeft);
                JTabbedPane tpRight = new JTabbedPane();
                tpRight.add("Field Help", new JPanel());
                tpRight.add("Image Navigation", new JPanel());
                spSub.setRightComponent(tpRight);


                JSplitPane spMain = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
                spMain.setLeftComponent(new JPanel());
                spMain.setRightComponent(spSub);


                JFrame frame = new JFrame("Testing");
                frame.setJMenuBar(mb);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(tb, BorderLayout.NORTH);
                frame.add(spMain, BorderLayout.CENTER);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

}