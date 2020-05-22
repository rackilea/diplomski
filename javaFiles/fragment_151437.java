public class TextFrame extends JPanel {

    private JToggleButton Go_Shadow;

    public TextFrame() {
        super(new GridBagLayout());

        setPreferredSize(new Dimension(300, 200));
        setBackground(Color.white);

        init();
    } // end of class constructor

    private void init() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // button to display date in textarea
        Go_Shadow = new JToggleButton("Shadow");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        add(Go_Shadow, gbc);

        // adding listeners to components
        // registering all components with their respective listeners
        Go_Shadow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame window = (JFrame) SwingUtilities.getWindowAncestor(TextFrame.this);
                Point location = window.getLocation();
                if (Go_Shadow.isSelected()) {
                    window.dispose();
                    window.setUndecorated(true);
                    window.setOpacity(0.5f);
                    setOpaque(false);
                } else {
                    window.dispose();
                    window.setOpacity(1f);
                    window.setUndecorated(false);
                    setOpaque(true);
                }
                window.setLocation(location);
                window.setVisible(true);
            }
        });

    }

} // end of TextFrame class