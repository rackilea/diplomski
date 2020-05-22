package Main;

import java.awt.*;

import javax.swing.*;

public class dummyGUI {
private static JPanel infopane, bedsPane, logopane, mainPanel;
private static JLabel lmalebed, lfemalebed, logoLabel;

public dummyGUI() {
    showUI();
}

public static void showUI() {

    int bedCount = 7; // getBedCount();
    bedCount = bedCount - 5;

    Toolkit tk = Toolkit.getDefaultToolkit();
    int xSize = ((int) tk.getScreenSize().getWidth());
    int ySize = ((int) tk.getScreenSize().getHeight());

    ImageIcon maleBed = new ImageIcon("Images/Male.png");
    ImageIcon femaleBed = new ImageIcon("Images/Female.png");
    ImageIcon emptyBed = new ImageIcon("Images/empty.png");
    ImageIcon logo = new ImageIcon("Images/logo-sample.png");
    ImageIcon mlogo = new ImageIcon("Images/Medicalistics_Logo.png");

    JFrame window = new JFrame("Ft Lauderdale");
    window.setVisible(true);
    window.setSize(xSize, ySize);

    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GridBagLayout gridBagLayout = new GridBagLayout();
    gridBagLayout.columnWidths = new int[] { 897, 0 };
    gridBagLayout.rowHeights = new int[] { 504, 0, 0 };
    gridBagLayout.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
    gridBagLayout.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
    window.getContentPane().setLayout(gridBagLayout);

    mainPanel = new JPanel();
    mainPanel.setBackground(Color.white);
    GridBagConstraints gbc_mainPanel = new GridBagConstraints();
    gbc_mainPanel.insets = new Insets(0, 0, 5, 0);
    gbc_mainPanel.fill = GridBagConstraints.BOTH;
    gbc_mainPanel.gridx = 0;
    gbc_mainPanel.gridy = 0;
    window.getContentPane().add(mainPanel, gbc_mainPanel);
    GridBagLayout gbl_mainPanel = new GridBagLayout();
    gbl_mainPanel.columnWidths = new int[] { 286, 518, 0 };
    gbl_mainPanel.rowHeights = new int[] { 101, 367, 0 };
    gbl_mainPanel.columnWeights = new double[] { 1.0, 2.0, Double.MIN_VALUE };
    gbl_mainPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
    mainPanel.setLayout(gbl_mainPanel);

    logopane = new JPanel();
    logopane.setBackground(Color.WHITE);
    GridBagConstraints gbc_logopane = new GridBagConstraints();
    gbc_logopane.insets = new Insets(0, 0, 0, 0);
    gbc_logopane.fill = GridBagConstraints.BOTH;
    gbc_logopane.gridx = 0;
    gbc_logopane.gridy = 0;
    mainPanel.add(logopane, gbc_logopane);
    logopane.setLayout(new BorderLayout());

    logoLabel = new JLabel(logo);
    logopane.add(logoLabel, BorderLayout.NORTH);

    logoLabel.setHorizontalAlignment(JLabel.LEFT);

    infopane = new JPanel();
    infopane.setBackground(Color.WHITE);
    GridBagConstraints gbc_infopane = new GridBagConstraints();
    gbc_infopane.insets = new Insets(0, 0, 0, 0);
    gbc_infopane.fill = GridBagConstraints.BOTH;
    gbc_infopane.gridx = 1;
    gbc_infopane.gridy = 0;
    mainPanel.add(infopane, gbc_infopane);
    infopane.setLayout(new BorderLayout());

    bedsPane = new JPanel();
    GridBagConstraints gbc_bedsPane = new GridBagConstraints();
    gbc_bedsPane.gridwidth = 2;
    gbc_bedsPane.fill = GridBagConstraints.BOTH;
    gbc_bedsPane.gridx = 0;
    gbc_bedsPane.gridy = 1;
    mainPanel.add(bedsPane, gbc_bedsPane);
    GridBagLayout gbl_bedsPane = new GridBagLayout();
    gbl_bedsPane.columnWidths = new int[] { 1, 0, 0, 0, 0 };
    gbl_bedsPane.rowHeights = new int[] { 1, 0, 0, 0 };
    gbl_bedsPane.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
    gbl_bedsPane.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
    bedsPane.setLayout(gbl_bedsPane);

    lmalebed = new JLabel(maleBed);
    GridBagConstraints gbc_lmalebed = new GridBagConstraints();
    gbc_lmalebed.insets = new Insets(0, 0, 0, 0);
    gbc_lmalebed.gridx = 1;
    gbc_lmalebed.gridy = 1;
    bedsPane.add(lmalebed, gbc_lmalebed);

    lfemalebed = new JLabel(femaleBed);
    GridBagConstraints gbc_lfemalebed = new GridBagConstraints();
    gbc_lfemalebed.gridx = 3;
    gbc_lfemalebed.gridy = 1;
    bedsPane.add(lfemalebed, gbc_lfemalebed);

}

public static void main(String[] args) {
    new dummyGUI();
}
}