public class DamagePanel extends JPanel {
    private JLabel label;

    public DamagePanel(final String ident) {
        label = new JLabel(ident);
        this.add(label);
    }

    public String getIdent() {
        return label.getText();
    }

    public void reportDamage(int[]damage, int x, int y) {
        ...
    }
}