public class Test {

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    JFrameExt frame = new JFrameExt();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static class ScrollablePane extends JPanel implements Scrollable {

        @Override
        public Dimension getPreferredScrollableViewportSize() {
            return new Dimension(100, 100);
        }

        @Override
        public int getScrollableUnitIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 64;
        }

        @Override
        public int getScrollableBlockIncrement(Rectangle visibleRect, int orientation, int direction) {
            return 128;
        }

        @Override
        public boolean getScrollableTracksViewportWidth() {
            return true;
        }

        @Override
        public boolean getScrollableTracksViewportHeight() {
            return false;
        }

    }

    public static class JFrameExt extends JFrame {

        private JPanel contentPane;

        /**
         * Create the frame.
         */
        public JFrameExt() {
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setBounds(100, 100, 246, 164);
            contentPane = new JPanel();
            contentPane.setBorder(null);
            contentPane.setLayout(new BorderLayout(0, 0));
            setContentPane(contentPane);

            JScrollPane scrollPane = new JScrollPane();
            scrollPane.setViewportBorder(null);
            scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
            contentPane.add(scrollPane, BorderLayout.CENTER);

            JPanel panel = new ScrollablePane();
            scrollPane.setViewportView(panel);
            GridBagLayout gbl_panel = new GridBagLayout();
//            gbl_panel.columnWidths = new int[]{0, 0};
//            gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0};
//            gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
//            gbl_panel.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
            panel.setLayout(gbl_panel);

            panelWithText panelWithText_ = new panelWithText();
            GridBagConstraints gbc_panelWithText_ = new GridBagConstraints();
            gbc_panelWithText_.anchor = GridBagConstraints.NORTH;
            gbc_panelWithText_.insets = new Insets(0, 0, 5, 0);
            gbc_panelWithText_.fill = GridBagConstraints.HORIZONTAL;
            gbc_panelWithText_.gridx = 0;
            gbc_panelWithText_.gridy = 0;
            gbc_panelWithText_.weightx = 1;
            panel.add(panelWithText_, gbc_panelWithText_);

//            panelWithText panelWithText__1 = new panelWithText();
//            GridBagConstraints gbc_panelWithText__1 = new GridBagConstraints();
//            gbc_panelWithText__1.insets = new Insets(0, 0, 5, 0);
//            gbc_panelWithText__1.anchor = GridBagConstraints.NORTH;
////            gbc_panelWithText__1.fill = GridBagConstraints.HORIZONTAL;
//            gbc_panelWithText__1.gridx = 0;
//            gbc_panelWithText__1.gridy = 1;
//            panel.add(panelWithText__1, gbc_panelWithText__1);
//
//            panelWithText panelWithText__2 = new panelWithText();
//            GridBagConstraints gbc_panelWithText__2 = new GridBagConstraints();
//            gbc_panelWithText__2.insets = new Insets(0, 0, 5, 0);
////            gbc_panelWithText__2.fill = GridBagConstraints.BOTH;
//            gbc_panelWithText__2.gridx = 0;
//            gbc_panelWithText__2.gridy = 2;
//            panel.add(panelWithText__2, gbc_panelWithText__2);
//
//            panelWithText panelWithText__3 = new panelWithText();
//            GridBagConstraints gbc_panelWithText__3 = new GridBagConstraints();
//            gbc_panelWithText__3.insets = new Insets(0, 0, 5, 0);
////            gbc_panelWithText__3.fill = GridBagConstraints.BOTH;
//            gbc_panelWithText__3.gridx = 0;
//            gbc_panelWithText__3.gridy = 3;
//            panel.add(panelWithText__3, gbc_panelWithText__3);
//
//            panelWithText panelWithText__4 = new panelWithText();
//            GridBagConstraints gbc_panelWithText__4 = new GridBagConstraints();
//            gbc_panelWithText__4.insets = new Insets(0, 0, 5, 0);
////            gbc_panelWithText__4.fill = GridBagConstraints.BOTH;
//            gbc_panelWithText__4.gridx = 0;
//            gbc_panelWithText__4.gridy = 4;
//            panel.add(panelWithText__4, gbc_panelWithText__4);
//
//            panelWithText panelWithText__5 = new panelWithText();
//            GridBagConstraints gbc_panelWithText__5 = new GridBagConstraints();
//            gbc_panelWithText__5.insets = new Insets(0, 0, 5, 0);
////            gbc_panelWithText__5.fill = GridBagConstraints.BOTH;
//            gbc_panelWithText__5.gridx = 0;
//            gbc_panelWithText__5.gridy = 5;
//            panel.add(panelWithText__5, gbc_panelWithText__5);
//
//            panelWithText panelWithText__6 = new panelWithText();
//            GridBagConstraints gbc_panelWithText__6 = new GridBagConstraints();
////            gbc_panelWithText__6.fill = GridBagConstraints.BOTH;
//            gbc_panelWithText__6.gridx = 0;
//            gbc_panelWithText__6.gridy = 6;
//            panel.add(panelWithText__6, gbc_panelWithText__6);
            setSize(300, 100);
        }
    }

    public static class panelWithText extends JPanel {

        /**
         * Create the panel.
         */
        public void me_resized(Dimension d) {
            System.out.println("CALLED..");
            super.setPreferredSize(d);
        }

        public panelWithText() {
            setBackground(Color.DARK_GRAY);
            setForeground(Color.WHITE);
            setLayout(new BorderLayout(0, 0));

            JTextArea txtrIveBeenReading = new JTextArea();
            txtrIveBeenReading.setEditable(false);
            txtrIveBeenReading.setColumns(28);
            txtrIveBeenReading.setFont(new Font("Tahoma", Font.PLAIN, 10));
            txtrIveBeenReading.setLineWrap(true);
            txtrIveBeenReading.setWrapStyleWord(true);
            txtrIveBeenReading.setText("\n A bunch of really important text here... A bunch of really important text here... A bunch of really important text here... A bunch of really important text here...\n");
            txtrIveBeenReading.setForeground(Color.WHITE);
            txtrIveBeenReading.setBackground(Color.DARK_GRAY);
            add(txtrIveBeenReading, BorderLayout.CENTER);

        }
    }
}