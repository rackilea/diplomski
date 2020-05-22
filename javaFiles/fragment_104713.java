public class QuadraticEquations extends javax.swing.JFrame {

    /**
    * Creates new form QuadraticEquations
    */
    public QuadraticEquations() {
        initComponents();
    }

    private void initComponents() {
        mainPanel = new javax.swing.JPanel();
        headerLabel = new javax.swing.JLabel();
        authorLabel = new javax.swing.JLabel();
        subHeaderLabel = new javax.swing.JLabel();
        a_Label = new javax.swing.JLabel();
        b_Label = new javax.swing.JLabel();
        c_Label = new javax.swing.JLabel();
        a_Value = new javax.swing.JTextField();
        b_Value = new javax.swing.JTextField();
        c_Value = new javax.swing.JTextField();
        calc_Button = new javax.swing.JButton();
        resultLabel = new javax.swing.JLabel();
        root1_Label = new javax.swing.JLabel();
        root2_Label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quadratic Equations Roots Calculator");

        headerLabel.setFont(new java.awt.Font("Lucida Fax", 1, 18)); // NOI18N
        headerLabel.setForeground(new java.awt.Color(0, 0, 255));
        headerLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        headerLabel.setText("Quadratic Equations - Roots Calculator");

        authorLabel.setFont(new java.awt.Font("Lucida Fax", 1, 14)); // NOI18N
        authorLabel.setForeground(new java.awt.Color(0, 165, 0));
        authorLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        authorLabel.setText("Afaan Bilal");

        subHeaderLabel.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        subHeaderLabel.setText("Enter the values of 'a', 'b', 'c' : ");

        a_Label.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        a_Label.setForeground(new java.awt.Color(25, 22, 200));
        a_Label.setText("\" a \" :");

        b_Label.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        b_Label.setForeground(new java.awt.Color(25, 22, 200));
        b_Label.setText("\" b \" :");

        c_Label.setFont(new java.awt.Font("Lucida Fax", 1, 12)); // NOI18N
        c_Label.setForeground(new java.awt.Color(25, 22, 200));
        c_Label.setText("\" c \" :");

        a_Value.setText("1");
        b_Value.setText("2");
        c_Value.setText("1");

        calc_Button.setText("Calculate Roots!");
        calc_Button.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CalculateRoots(evt);
            }
        });

        resultLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        root1_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        root2_Label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        mainPanel.setLayout(new java.awt.GridLayout(0,1));
        mainPanel.add(headerLabel);
        mainPanel.add(authorLabel);
        mainPanel.add(subHeaderLabel);
        mainPanel.add(a_Label);
        mainPanel.add(a_Value);
        mainPanel.add(b_Label);
        mainPanel.add(b_Value);
        mainPanel.add(c_Label);
        mainPanel.add(c_Value);
        mainPanel.add(calc_Button);
        mainPanel.add(resultLabel);
        mainPanel.add(root1_Label);
        mainPanel.add(root2_Label);

        add(mainPanel);
        pack();
        setLocationRelativeTo(null);
    }

    private void CalculateRoots(java.awt.event.ActionEvent evt) {

        double a = Double.parseDouble(a_Value.getText());
        double b = Double.parseDouble(b_Value.getText());
        double c = Double.parseDouble(c_Value.getText());
        double d = 0.0;
        double r1 = 0.0;
        double r2 = 0.0;

        if (a == 0) {
            resultLabel.setText("Error: The value of \"a\" cannot be zero.");
            root1_Label.setText("");
            root2_Label.setText("");
        } else {
            d = (b * b) - 4 * a * c;
            if (d < 0) {
                resultLabel.setText("Error: The value of \"D\" is negative.");
                root1_Label.setText("Therefore, Real roots do not exist.");
                root2_Label.setText("");
            } else {
                r1 = (-b + Math.sqrt(d)) / 2 * a;
                r2 = (-b - Math.sqrt(d)) / 2 * a;
                resultLabel.setText("The value of \"D\" is " + d);
                root1_Label.setText("The first root is " + r1);
                root2_Label.setText("The second root is " + r2);
            }
        }
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        /*
        * Create and display the form
        */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new QuadraticEquations().setVisible(true);
            }
        });
    }
    // Variables declaration
    private javax.swing.JLabel authorLabel;
    private javax.swing.JLabel headerLabel;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel resultLabel;
    private javax.swing.JLabel root1_Label;
    private javax.swing.JLabel root2_Label;
    private javax.swing.JLabel subHeaderLabel;
    private javax.swing.JLabel a_Label;
    private javax.swing.JTextField a_Value;
    private javax.swing.JLabel b_Label;
    private javax.swing.JTextField b_Value;
    private javax.swing.JLabel c_Label;
    private javax.swing.JTextField c_Value;
    private javax.swing.JButton calc_Button;
    // End of variables declaration
}