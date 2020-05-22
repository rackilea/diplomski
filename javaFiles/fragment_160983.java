public class Test extends JFrame {
public Test() {

    JPanel testPanel = new JPanel();
    setContentPane(testPanel);
    GridBagLayout gbl_testPanel = new GridBagLayout();
    gbl_testPanel.columnWidths = new int[]{0, 0};
    gbl_testPanel.rowHeights = new int[]{0};
    gbl_testPanel.columnWeights = new double[]{0.5, 0.5};
    gbl_testPanel.rowWeights = new double[]{1.0};
    testPanel.setLayout(gbl_testPanel);

    JPanel leftPanel = new JPanel();
    GridBagConstraints gbc_leftPanel = new GridBagConstraints();
    gbc_leftPanel.fill = GridBagConstraints.BOTH;
    gbc_leftPanel.insets = new Insets(0, 0, 0, 5);
    gbc_leftPanel.gridx = 0;
    gbc_leftPanel.gridy = 0;
    testPanel.add(leftPanel, gbc_leftPanel);
    GridBagLayout gbl_leftPanel = new GridBagLayout();
    gbl_leftPanel.columnWidths = new int[]{0};
    gbl_leftPanel.rowHeights = new int[]{0, 0};
    gbl_leftPanel.columnWeights = new double[]{0.0};
    gbl_leftPanel.rowWeights = new double[]{0.6, 0.4};
    leftPanel.setLayout(gbl_leftPanel);

    JLabel lbl00 = new JLabel("Upper Left");
    GridBagConstraints gbc_lbl00 = new GridBagConstraints();
    gbc_lbl00.anchor = GridBagConstraints.NORTH;
    gbc_lbl00.fill = GridBagConstraints.HORIZONTAL;
    gbc_lbl00.insets = new Insets(0, 0, 5, 0);
    gbc_lbl00.gridx = 0;
    gbc_lbl00.gridy = 0;
    leftPanel.add(lbl00, gbc_lbl00);

    JLabel lbl10 = new JLabel("Lower Left");
    GridBagConstraints gbc_lbl10 = new GridBagConstraints();
    gbc_lbl10.anchor = GridBagConstraints.NORTH;
    gbc_lbl10.fill = GridBagConstraints.HORIZONTAL;
    gbc_lbl10.gridx = 0;
    gbc_lbl10.gridy = 1;
    leftPanel.add(lbl10, gbc_lbl10);

    JPanel rightPanel = new JPanel();
    GridBagConstraints gbc_rightPanel = new GridBagConstraints();
    gbc_rightPanel.fill = GridBagConstraints.BOTH;
    gbc_rightPanel.gridx = 1;
    gbc_rightPanel.gridy = 0;
    testPanel.add(rightPanel, gbc_rightPanel);
    GridBagLayout gbl_rightPanel = new GridBagLayout();
    gbl_rightPanel.columnWidths = new int[]{0};
    gbl_rightPanel.rowHeights = new int[]{0, 0};
    gbl_rightPanel.columnWeights = new double[]{0.0};
    gbl_rightPanel.rowWeights = new double[]{0.4, 0.6};
    rightPanel.setLayout(gbl_rightPanel);

    JLabel lbl01 = new JLabel("Upper Right");
    GridBagConstraints gbc_lbl01 = new GridBagConstraints();
    gbc_lbl01.insets = new Insets(0, 0, 5, 0);
    gbc_lbl01.fill = GridBagConstraints.HORIZONTAL;
    gbc_lbl01.anchor = GridBagConstraints.NORTH;
    gbc_lbl01.gridx = 0;
    gbc_lbl01.gridy = 0;
    rightPanel.add(lbl01, gbc_lbl01);

    JLabel lbl11 = new JLabel("Lower Right");
    GridBagConstraints gbc_lbl11 = new GridBagConstraints();
    gbc_lbl11.anchor = GridBagConstraints.NORTH;
    gbc_lbl11.fill = GridBagConstraints.HORIZONTAL;
    gbc_lbl11.gridx = 0;
    gbc_lbl11.gridy = 1;
    rightPanel.add(lbl11, gbc_lbl11);
}