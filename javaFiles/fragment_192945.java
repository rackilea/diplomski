public class Firstcard1 extends javax.swing.JPanel {
    ....

    private SecondCard secondCard;

    void setSecondCard(SecondCard secondCard)
    { 
        this.secondCard = secondCard;
    }

    ....

    private void LoginActionPerformed(java.awt.event.ActionEvent evt)
    {                                      
        CardLayout layout = (CardLayout)contentpane.getLayout();
        layout.show(contentpane, "Panel 2");
        secondCard.getTextField().setText(jTextField1.getText());
    }                                 
}