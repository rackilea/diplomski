public class Dialog extends javax.swing.JDialog {

    private GUI gui;

    public Dialog(GUI parent) {
        super(parent, true);
        this.gui = gui;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        save = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        save.setText("Save");
        save.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(save)
                                                        .addContainerGap())
        );
        layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(save)
                                                        .addContainerGap())
        );

        pack();
    }// </editor-fold>                        

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {
        gui.save(1);
    }

    private javax.swing.JButton save;
}