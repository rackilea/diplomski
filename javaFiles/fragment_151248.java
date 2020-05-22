public int addRow(String name, String price, String quantity) {
    Object[] row = new Object[3];
    row[0] = name;
    row[1] = price;
    row[2] = quantity;
    model.addRow(row); 
    int total = 0;
    for (int count = 0; count < model.getRowCount(); count++){
        price = model.getValueAt(count, 1).toString();
        quantity = model.getValueAt(count, 2).toString();
        if(price != null && !price.trim().equals("") && quantity != null && !quantity.trim().equals("")) {
            total += Integer.parseInt(price) * Integer.parseInt(quantity);
        }
    }
    return total;
}

public class FuButtonPanel extends JPanel {
    private JButton addInfoButton = new JButton("Add Information");
    public JLabel total = new JLabel("Total : ");

    public FuButtonPanel() {
        add(addInfoButton);
        add(total);
    }

    public void addInfoBtnAddActionListener(ActionListener listener) {
        addInfoButton.addActionListener(listener);
    }

    public void setTotal(int total) {
        this.total.setText("Total : " + total);
    }
}