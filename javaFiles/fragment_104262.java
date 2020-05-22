public class Demo2 implements ActionListener {
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Demo2();
      }
    });
  }

  private JFrame frame;
  private JPanel textPanel;
  private JButton butt1, butt2, butt3;

  public Demo2() {
    frame = new JFrame("Demo");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(true);
    frame.setBounds(0, 0, 800, 800);

    commence();
  }

  private void commence() {
    GridBagConstraints gb = new GridBagConstraints();
    gb.anchor = GridBagConstraints.FIRST_LINE_START;
    gb.weightx = 1;
    gb.insets = new Insets(50, 5, 0, 20);

    JPanel mainPanel = new JPanel();
    mainPanel.setBackground(Color.white);
    mainPanel.setLayout( new GridBagLayout() );

    butt1 = new JButton("One");
    butt1.setPreferredSize( new Dimension(100, 50) );
    // Add to panel
    gb.gridx = 0;
    gb.gridy = 0;
    mainPanel.add( butt1, gb);

    butt2 = new JButton("Two");
    butt2.setPreferredSize( new Dimension(100, 50) );
    butt2.addActionListener(this);
    // Add to panel
    gb.gridy++;
    gb.insets = new Insets(50, 5, 0, 0);
    mainPanel.add( butt2, gb );

    textPanel = new JPanel(new GridLayout(0, 1));
    // Add to panel
    gb.gridy++;
    gb.insets = new Insets(0, 5, 0, 20);
    mainPanel.add( textPanel, gb );

    butt3 = new JButton("Three");
    butt3.setPreferredSize( new Dimension(100, 50) );
    // Add to panel
    gb.gridy++;
    gb.insets = new Insets(50, 5, 0, 20);
    mainPanel.add( butt3, gb );

    frame.add(mainPanel);
    frame.setVisible(true);
    frame.repaint();
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if(e.getSource().equals( butt2 )) {
      commence2();
    }
  }

  private void commence2() {
    JTextField jtf = new JTextField(30);

    JLabel label = new JLabel("LABEL 2   ");
    label.setDisplayedMnemonic(KeyEvent.VK_N );
    label.setLabelFor( jtf );

    JPanel panel = new JPanel( new FlowLayout(FlowLayout.LEFT, 10, 3));
    panel.setBackground( Color.white );
    panel.add(label);
    panel.add( jtf );

    // Add to mainPanel
    textPanel.add( panel );
    textPanel.revalidate();

    frame.revalidate();
    frame.repaint();
  }
}