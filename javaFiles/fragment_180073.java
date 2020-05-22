public class CotizacionGUI extends javax.swing.JFrame{
    public CotizacionGUI() {
        initComponents();
    }
    private void buttonCallFrame2ActionPerformed(java.awt.event.ActionEvent evt) {                                           
        BuscarCotizacionGUI bC = new BuscarCotizacionGUI(this);
        bC.setVisible();
    }  
}