public class MainFrame extends JFrame {

private JPanel topPanel = new JPanel();
private JPanel centerPanel = new JPanel();
private JToggleButton toggleButton = new JToggleButton("Toggle");

public MainFrame() {
    this.setVisible(true);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());

    this.topPanel.setPreferredSize(new Dimension(100, 100));
    this.centerPanel.setPreferredSize(new Dimension(100, 100));
    this.toggleButton.setPreferredSize(new Dimension(100, 100));

    this.add(topPanel, BorderLayout.NORTH);
    this.add(centerPanel, BorderLayout.CENTER);
    this.add(toggleButton, BorderLayout.SOUTH);

    this.toggleButton.addItemListener(new ItemListener() {
        @Override
        public void itemStateChanged(ItemEvent e) {
            if(e.getStateChange() == ItemEvent.SELECTED) {
                add(centerPanel, BorderLayout.CENTER);
            } else {
                remove(centerPanel);
            }
            pack();
        }
    });

    this.pack();
    this.setVisible(true);
}
}