public class LayoutManagement extends JComponent {

public LayoutManagement() {
    setLayout(new BorderLayout());//CHANGE use BorderLayout instead of FLowlayout

    JPanel main = new JPanel(new GridLayout(1,3,20,0));
    main.setBorder(new EmptyBorder(10,10,10,10));

    final JLabel message = new JLabel("Default Message");

    JPanel pnlNorth = new JPanel();//CHANGE add the buttons to a panel
    pnlNorth.setLayout(new FlowLayout());//CHANGE set its layout
    String[] labels = "This class will give you practice creating and laying out containers".split("\\s");
    for (final String label : labels) {
        JButton button = new JButton(label);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message.setText(label);
            }
        });
        pnlNorth.add(button);//CHANGE add buttons to the panel
    }
    add(pnlNorth, BorderLayout.NORTH);//CHANGE add the panel to the north section

    main.add(message, BorderLayout.NORTH);

    JPanel column1 = new JPanel(new GridLayout(6,1,0,5));
    JPanel column2 = new JPanel(new GridLayout(2,1,0,5));
    JPanel column3 = new JPanel(new GridLayout(5,1,0,5));
    JPanel col1 = new JPanel(new BorderLayout());
    JPanel col2 = new JPanel(new BorderLayout());
    JPanel col3 = new JPanel(new BorderLayout());
    JPanel col1ex = new JPanel(new GridBagLayout());
    JPanel col2ex = new JPanel(new GridBagLayout());
    JPanel col3ex = new JPanel(new GridBagLayout());
    main.add(col1, BorderLayout.SOUTH);
    main.add(col2, BorderLayout.SOUTH);
    main.add(col3, BorderLayout.SOUTH);

    final JLabel message1 = new JLabel();
    message1.setPreferredSize(new Dimension(125, 50));
    message1.setBackground(Color.PINK);
    message1.setOpaque(true);
    message1.setBorder(new TitledBorder("Message 1"));
    message1.setHorizontalAlignment(0);

    final JLabel message2 = new JLabel();
    message2.setPreferredSize(new Dimension(125,50));
    message2.setBackground(Color.PINK);
    message2.setOpaque(true);
    message2.setBorder(new TitledBorder("Message 2"));
    message2.setHorizontalAlignment(0);

    String[] label1 = "This class will give you practice".split("\\s");
    for(final String label : label1) {
        JButton button = new JButton(label);
        button.setBackground(Color.CYAN);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message1.setText(label);
            }
        });
        column1.add(button);
    }

    String[] label2 = "creating and laying out containers".split("\\s");
    for(final String label : label2) {
        JButton button = new JButton(label);
        button.setBackground(Color.CYAN);
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                message2.setText(label);
            }
        });
        column3.add(button);
    }

    col1ex.add(column1);
    col1.add(col1ex);
    col2ex.add(column2);
    column2.add(message1);
    column2.add(message2);
    col2.add(col2ex);
    col3ex.add(column3);
    col3.add(col3ex);

    add(main, BorderLayout.CENTER); //CHANGE put the other stuff in the center section
}