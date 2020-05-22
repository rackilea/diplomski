import javax.swing.table.DefaultTableCellRenderer;

public class BMIRenderer extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {

        Person person = null;
        String bmiValue = "";
        if(value instanceof Person) {
            person = (Person)value;
            bmiValue = Integer.toString(person.getBMI());
        }

        //Pass just the bmiValue to the super method so the integer's toString() value is displayed
        super.getTableCellRendererComponent(table, bmiValue, isSelected, hasFocus, row, column);

        if(person != null) {
            if (person.getBMI() < 18) {
                super.setBackground(Color.YELLOW);
            } 
            else if (person.getBMI() > 25) {
                setBackground(Color.RED);
            }
        }

        return this;
    }
}