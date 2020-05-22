public class RecordLine extends JPanel{

    public RecordLine(Product product){
        JTextField fieldName = new JTextField();
        fieldName.setText(product.getName());
        this.add(fieldName);

        Component horizontalStrut = Box.createHorizontalStrut(20);
        this.add(horizontalStrut);

        //Subclass code should be executed here

        Component horizontalStrut_1 = Box.createHorizontalStrut(20);
        this.add(horizontalStrut_1);

        addBeforeMinButton();

        JButton buttonMin = new JButton("-");
        this.add(buttonMin);
    }

    protected void addBeforeMinButton() {
    }
}