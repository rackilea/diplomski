public class ViewLineNumbs extends javax.swing.JFrame {
int i=0;
JTextArea tx,lines;
JScrollPane scrollpane;
public ViewLineNumbs() {
    initComponents();
}
@SuppressWarnings("unchecked")
// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
private void initComponents() {

    tp = new javax.swing.JTabbedPane();
    jMenuBar1 = new javax.swing.JMenuBar();
    jMenu1 = new javax.swing.JMenu();
    Create = new javax.swing.JMenuItem();
    ViewLineNumbers = new javax.swing.JCheckBoxMenuItem();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jMenu1.setText("File");

    Create.setText("Create");
    Create.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            CreateActionPerformed(evt);
        }
    });
    jMenu1.add(Create);

    ViewLineNumbers.setSelected(true);
    ViewLineNumbers.setText("ViewLineNumbers");
    ViewLineNumbers.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            ViewLineNumbersActionPerformed(evt);
        }
    });
    jMenu1.add(ViewLineNumbers);

    jMenuBar1.add(jMenu1);

    setJMenuBar(jMenuBar1);

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
        .addComponent(tp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE)
    );

    pack();
}// </editor-fold>                        

private void CreateActionPerformed(java.awt.event.ActionEvent evt) {                                       
    final JInternalFrame internalFrame = new JInternalFrame("");
    i++;
    internalFrame.setName("Document"+i);
    internalFrame.setClosable(true);
    internalFrame.setAutoscrolls(true);
    tx=new JTextArea();
    tx.setFont(new java.awt.Font("Miriam Fixed", 0, 13));
    scrollpane=new JScrollPane(tx);
    internalFrame.add(scrollpane);
    tp.add(internalFrame);
    internalFrame.setSize(internalFrame.getMaximumSize());
    internalFrame.pack();
    internalFrame.setVisible(true);
}                                      

private void ViewLineNumbersActionPerformed(java.awt.event.ActionEvent evt) {                                                

        ViewLineNumbers.addItemListener(new ItemListener() {
               @Override
               public void itemStateChanged(ItemEvent ie) {
                  if(ViewLineNumbers.getState()){
                    lines = new JTextArea("");
                    lines.setBackground(Color.LIGHT_GRAY);
            lines.setEditable(false);
                    lines.setSize(10,10);
                    lines.setFont(new java.awt.Font("Miriam Fixed", 0, 13));
                    lines.setText(getText());
                    tx.getDocument().addDocumentListener(new DocumentListener(){

        @Override
        public void changedUpdate(DocumentEvent de) {
            lines.setText(getText());
        }
        @Override
        public void insertUpdate(DocumentEvent de) {
            lines.setText(getText());
        }

        @Override
        public void removeUpdate(DocumentEvent de) {
            lines.setText(getText());
        }
    });

                   scrollpane.getViewport().add(tx);
                   scrollpane.setRowHeaderView(lines); 
                   }
                   else{
                       scrollpane.setRowHeaderView(null);

                   }
               }
          });
}                                               
public String getText(){
    int caretPosition = tx.getDocument().getLength();
    Element root = tx.getDocument().getDefaultRootElement();
    String text = "1" + System.getProperty("line.separator");
    for(int i = 2; i < root.getElementIndex( caretPosition ) + 1; i++){
        text += i + System.getProperty("line.separator");
    }
    return text;
 }
public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Nimbus".equals(info.getName())) {
                javax.swing.UIManager.setLookAndFeel(info.getClassName());
                break;
            }
        }
    } catch (ClassNotFoundException ex) {
        java.util.logging.Logger.getLogger(ViewLineNumbs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
        java.util.logging.Logger.getLogger(ViewLineNumbs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
        java.util.logging.Logger.getLogger(ViewLineNumbs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        java.util.logging.Logger.getLogger(ViewLineNumbs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            new ViewLineNumbs().setVisible(true);
        }
    });
}
// Variables declaration - do not modify                     
private javax.swing.JMenuItem Create;
private javax.swing.JCheckBoxMenuItem ViewLineNumbers;
private javax.swing.JMenu jMenu1;
private javax.swing.JMenuBar jMenuBar1;
private javax.swing.JTabbedPane tp;
// End of variables declaration 
}