import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Objects;
import javax.swing.BorderFactory;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class JDViewCustomer extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;

    private JTextArea txtaObservation;
    private JPanel panelCustomerData;

    private final CustomerData customerData;
    private JLabel lblObservationLimit;


    public JDViewCustomer(java.awt.Frame parent, boolean modal, CustomerData customerData) {
        super(parent, modal);
        this.customerData = Objects.requireNonNull(customerData);

        getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        layoutCustomerDataSection();
        addCustomerData();

        initComponents();
    }

    public void layoutCustomerDataSection() {
        panelCustomerData = new JPanel();
        panelCustomerData.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 1, true), new EmptyBorder(10, 10, 10, 10)));
        panelCustomerData.setBackground(Color.WHITE);

        getContentPane().add(panelCustomerData);

        GridBagLayout gbl_panelCustomerData = new GridBagLayout();
        gbl_panelCustomerData.columnWidths = new int[]{58, 199, 38, 102, 27, 138, 0};
        gbl_panelCustomerData.rowHeights = new int[]{0, 14, 0};
        gbl_panelCustomerData.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gbl_panelCustomerData.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
        panelCustomerData.setLayout(gbl_panelCustomerData);

        lblObservationLimit = new JLabel("Observation limit");
        GridBagConstraints gbc_lblObservationLimit = new GridBagConstraints();
        gbc_lblObservationLimit.insets = new Insets(0, 0, 5, 0);
        gbc_lblObservationLimit.gridx = 5;
        gbc_lblObservationLimit.gridy = 0;
// kwb set gridheight to total number of rows
        gbc_lblObservationLimit.gridheight = 2;
        panelCustomerData.add(lblObservationLimit, gbc_lblObservationLimit);

        txtaObservation = new JTextArea("Observation text");
// kwb just to help view issue
        txtaObservation.setBorder(BorderFactory.createLineBorder(Color.blue));
        txtaObservation.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtaObservation.setLineWrap(true);
        txtaObservation.setWrapStyleWord(true);
        GridBagConstraints gbc_txtaObservation = new GridBagConstraints();
        gbc_txtaObservation.gridwidth = 5;
        gbc_txtaObservation.anchor = GridBagConstraints.NORTHWEST;
// kwb fill all available horizontal space
        gbc_txtaObservation.fill = GridBagConstraints.HORIZONTAL;
// kwb change to start in column 0, adjust as necessary
        gbc_txtaObservation.gridx = 0;
        gbc_txtaObservation.gridy = 1;
        panelCustomerData.add(txtaObservation, gbc_txtaObservation);
    }

    public void addCustomerData() {
        txtaObservation.setText(customerData.getObservation());
    }

    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("View customer");

        pack();
        setLocationRelativeTo(getParent());
    }
}