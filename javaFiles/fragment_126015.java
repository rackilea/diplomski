public class MyCoolCheckbox extends JComponent{
    private JCheckBox checkbox;
    public MyCoolCheckbox(String label) {
        checkbox= new JCheckBox(label);
        this.setLayout(new BorderLayout());
        this.add(checkbox, BorderLayout.CENTER);
    }
}