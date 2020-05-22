package Package_main;

import java.awt.AWTException;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;


public class Main_Class extends javax.swing.JFrame {

    public static void main (String [] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main_Class().setVisible(true);
            }
        });

    }

public Main_Class() {
    initComponents();
} 

private javax.swing.JButton jButton1;
private javax.swing.JButton jButton2;
private javax.swing.JLabel jLabel1;
private javax.swing.JTextField jTextField1;
private org.jdesktop.beansbinding.BindingGroup bindingGroup;

private void initComponents() {

    java.awt.GridBagConstraints gridBagConstraints;
    bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jButton1 = new javax.swing.JButton();
    jButton2 = new javax.swing.JButton();
    jTextField1 = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();

    setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
    setPreferredSize(new java.awt.Dimension(325, 106));
    setSize(getPreferredSize());

    org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${VK_ESCAPE}"), this, org.jdesktop.beansbinding.BeanProperty.create("defaultCloseOperation"));
    bindingGroup.addBinding(binding);

    getContentPane().setLayout(new java.awt.GridBagLayout());

    jButton1.setText("Start");
    jButton1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            try {
                jButton1ActionPerformed(evt);
            } catch (AWTException ex) {
                Logger.getLogger(Main_Class.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 2;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(6, 18, 11, 0);
    getContentPane().add(jButton1, gridBagConstraints);

    jButton2.setText("Stop");
    jButton2.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton2ActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 3;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.ipadx = 2;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(6, 18, 11, 10);
    getContentPane().add(jButton2, gridBagConstraints);

    jTextField1.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField1ActionPerformed(evt);
        }
    });
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 1;
    gridBagConstraints.gridwidth = 2;
    gridBagConstraints.ipadx = 131;
    gridBagConstraints.ipady = 3;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(6, 10, 11, 0);
    getContentPane().add(jTextField1, gridBagConstraints);

    jLabel1.setText("Timer (in seconds)");
    gridBagConstraints = new java.awt.GridBagConstraints();
    gridBagConstraints.gridx = 0;
    gridBagConstraints.gridy = 0;
    gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
    gridBagConstraints.insets = new java.awt.Insets(11, 10, 0, 0);
    getContentPane().add(jLabel1, gridBagConstraints);

    bindingGroup.bind();

    pack();
}

double time;
double time_milli;

private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
    time = Double.parseDouble(jTextField1.getText()); 
    System.out.println(time);
    time_milli = time * 1000;
}                                           

Worker_Thread wt;

private void jButton1ActionPerformed(ActionEvent evt) throws AWTException {
    time = Double.parseDouble(jTextField1.getText()); 
    System.out.println(time);
    time_milli = time * 1000;

    wt = new Worker_Thread(time_milli);
    new Thread(wt).start();
}

private void jButton2ActionPerformed(ActionEvent evt) {
    wt.stop=true;
    System.out.println("stopped");
}

}