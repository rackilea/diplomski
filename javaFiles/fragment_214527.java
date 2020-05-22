private JPanel getTest1(){

        MigLayout layout = new MigLayout("debug");
        JPanel content = new JPanel(layout);
        content.setMaximumSize(new Dimension(getCenterPanel().getWidth(), 40));

        JCheckBox a1 = new JCheckBox("d");
        content.add(a1, "gapright 10, height 30, width 250, cell 0 0");

        JLabel label = new JLabel();
        label.setBackground(Color.RED);
        label.setOpaque(true);
        content.add(label, "gapright 10, height 30, width 30, cell 1 0");

        JButton btn = new JButton("try again");
        content.add(btn,"height 30, width 80, cell 2 0" );

        return content;

    }