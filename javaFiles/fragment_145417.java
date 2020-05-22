public class SmartTextField implements FocusListener{
private JTextField field;
public SmartTextField(JTextField field) {
    this.field = field;
}
@Override
public void focusGained(FocusEvent e) {
    System.out.println(e);
    //Here you can add logic that applies to the field, e.g.
    field.selectAll();
    ...
}
@Override
public void focusLost(FocusEvent e) {
    System.out.println(e);
    ...
}
public JTextField getField() {
    return field;
}