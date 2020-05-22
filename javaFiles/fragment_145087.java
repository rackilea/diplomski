JXCollapsiblePane top = new JXCollapsiblePane() {

//            @Override
//            public Dimension getMaximumSize() {
//                return getPreferredSize();
//            }

    };
    top.add(new JLabel("some random label"));
    top.add(new JLabel("and another"));
    top.add(new JButton(top.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION)));
    top.setCollapsed(true);
    JXFrame frame = new JXFrame("collapsible in top", true);
    frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
    frame.add(top, BorderLayout.NORTH);
    frame.add(new JScrollPane(new JXTable(50, 4)));
    frame.add(new JButton(top.getActionMap().get(JXCollapsiblePane.TOGGLE_ACTION)), BorderLayout.SOUTH);
    frame.pack();
    frame.setVisible(true);