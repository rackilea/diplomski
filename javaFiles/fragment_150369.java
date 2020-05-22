private Project project;

public JpMenuPrincipal(final Project project) {
    initComponents();
    this.project = project;
}

private void btnOptionClientActionPerformed(java.awt.event.ActionEvent evt) {                                                
    CardLayout card = project.getCardLayout();
    // do something with card
}