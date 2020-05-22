public static void main(String[] args) {

    // create JFrame
    JFrame _frame = new JFrame();

    JPanel conPanel = new JPanel(new BorderLayout());

    // create Mainpanel
    JPanel _mainPanel = new JPanel() {
        @Override
        public String toString() {
            return "All";
        }
    };

    // create Layout
    GridLayout _layout = new GridLayout(3, 3, 3, 3);

    // set gridlayout to mainpanel
    _mainPanel.setLayout(_layout);

    JComboBox<JPanel> combo = new JComboBox<>();

    combo.addItem(_mainPanel);

    for (int i = 0; i < 12; i++) {
        final int fi = i;
        JPanel _tempPanel = new JPanel() {
            @Override
            public String toString() {
                return "Panel" + fi;
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawString(toString(), 5, 15);
            }

        };
        _tempPanel.setBackground(Color.ORANGE);
        _tempPanel.setBorder(BorderFactory.createLineBorder(Color.black));

        _mainPanel.add(_tempPanel);

        combo.addItem(_tempPanel);

    }

    combo.addActionListener( e -> {

        JPanel panel = (JPanel)combo.getSelectedItem();

        conPanel.remove(_mainPanel);
        _mainPanel.removeAll();

        for(int i = 1; i < combo.getItemCount(); i++)
            _mainPanel.add(combo.getItemAt(i));

        conPanel.add(panel, BorderLayout.CENTER);

        conPanel.revalidate();

        conPanel.repaint();

    } );

    conPanel.add(_mainPanel, BorderLayout.CENTER);

    JPanel buttonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

    buttonsPanel.add(combo);

    conPanel.add(buttonsPanel, BorderLayout.SOUTH);

    // add mainpanel to frame
    _frame.setContentPane(conPanel);

    _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // set size of Jframe
    _frame.setSize(1000, 1000);
    _frame.setVisible(true);

}