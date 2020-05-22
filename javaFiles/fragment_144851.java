public interface Gettable {
    public void setLabelBackground(Color color);
}

public class Main extends JFrame implements Gettable {
    private JLabel jLabel1;
    private OtherPanel otherPanel;

    public void initComponents() {
        otherPanel = new OtherPanel(Main.this); // see link above to edit this area
    }

    @Override
    public void setLabelBackground(Color color) {
        jLabel1.setBackground(color);
    }
}

public class OtherPanel extends JPanel {
    private Gettable gettable;

    public OtherPanel(Gettable gettable) {
        this.gettable = gettable;
    }

    private void jButtonActionPerformed(ActionEvent e) {
        gettable.setLabelBackground(Color.RED);
    }
}