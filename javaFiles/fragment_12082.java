import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MyFrame extends javax.swing.JFrame {

    private static final String PROGRESS_BAR = "progress bar";
    private static final String EMPTY = "empty";
    public MyFrame() {
        initComponents();
    }

    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pb = new javax.swing.JProgressBar();
        bnVis = new javax.swing.JButton();
        bnInvis = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        //!!
        cardLayout = new CardLayout();
        cardHolderPanel = new JPanel(cardLayout);
        cardHolderPanel.add(pb, PROGRESS_BAR);
        cardHolderPanel.add(new JLabel(), EMPTY);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        bnVis.setText("Visible");
        bnVis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnVisActionPerformed(evt);
            }
        });

        bnInvis.setText("Not Visible");
        bnInvis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bnInvisActionPerformed(evt);
            }
        });

        jButton1.setText("Some Other Random Component");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(jPanel1Layout
                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        jPanel1Layout
                                .createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(cardHolderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 217,
                                        javax.swing.GroupLayout.PREFERRED_SIZE).addContainerGap(45, Short.MAX_VALUE))
                .addGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel1Layout
                                .createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(
                                        jPanel1Layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(
                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                        jPanel1Layout.createSequentialGroup().addComponent(bnVis)
                                                                .addGap(28, 28, 28).addComponent(bnInvis)
                                                                .addGap(47, 47, 47))
                                                .addGroup(
                                                        javax.swing.GroupLayout.Alignment.TRAILING,
                                                        jPanel1Layout.createSequentialGroup().addComponent(jButton1)
                                                                .addGap(30, 30, 30)))));
        jPanel1Layout.setVerticalGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(
                        javax.swing.GroupLayout.Alignment.TRAILING,
                        jPanel1Layout
                                .createSequentialGroup()
                                .addContainerGap(20, Short.MAX_VALUE)
                                .addGroup(
                                        jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(bnInvis).addComponent(bnVis))
                                .addGap(4, 4, 4)
                                .addComponent(cardHolderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 35,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                layout.createSequentialGroup()
                        .addContainerGap(22, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap()));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(
                layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(64, Short.MAX_VALUE)));

        pack();
    }// </editor-fold>

    private void bnVisActionPerformed(java.awt.event.ActionEvent evt) {
        // pb.setVisible(true);
        cardLayout.show(cardHolderPanel, PROGRESS_BAR);
    }

    private void bnInvisActionPerformed(java.awt.event.ActionEvent evt) {
        // pb.setVisible(false);  // !!
        cardLayout.show(cardHolderPanel, EMPTY);;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MyFrame().setVisible(true);
            }
        });
    }

    private javax.swing.JButton bnInvis;
    private javax.swing.JButton bnVis;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private CardLayout cardLayout;
    private JPanel cardHolderPanel;
    private javax.swing.JProgressBar pb;
}