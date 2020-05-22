import java.awt.*;
import javax.swing.*;

public class InitGraphics {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final DefaultListModel<Order> orderModel = new DefaultListModel<>();
            orderModel.addElement(new Order("One"));
            orderModel.addElement(new Order("Two"));
            orderModel.addElement(new Order("Three"));
            orderModel.addElement(new Order("Four"));
            orderModel.addElement(new Order("Five"));

            JList<Order> orderList = new JList<>(orderModel);
            orderList.setCellRenderer(new CookListCellRender());

            JPanel panel = new JPanel();
            panel.add(new JScrollPane(orderList));

            JOptionPane.showMessageDialog(null, panel);
        });
    }
}

class CookListCellRender extends JLabel implements ListCellRenderer<Order> {

    public CookListCellRender() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Order> list, Order value, int index,
            boolean isSelected, boolean cellHasFocus) {

        setLayout(new FlowLayout());
        setText(value.getNameEl());
        list.setVisibleRowCount(30);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        setFont(new Font("Arial", Font.ITALIC, 17));

        if (isSelected) {
            setBackground(Color.BLUE);
            setForeground(Color.BLUE);
        } else {
            // TODO: fix!
            // setBackground(getBackground());
            // setForeground(getForeground());
            setBackground(null);
            setForeground(null);
        }

        if (value.getOrderRead()) {
            setBackground(Color.YELLOW);
        } else {
            setBackground(Color.WHITE);
        }

        if (value.getOrderDone()) {
            setBackground(Color.GREEN);
        } else {
            setBackground(Color.WHITE);
        }
        return this;
    }

}

class Order {

    private String nameE1;
    private boolean orderDone;
    private boolean orderRead;

    public Order(String nameE1) {
        this.nameE1 = nameE1;
    }

    public String getNameEl() {
        return nameE1;
    }

    public boolean getOrderDone() {
        return orderDone;
    }

    public boolean getOrderRead() {
        return orderRead;
    }

    public void setOrderDone(boolean orderDone) {
        this.orderDone = orderDone;
    }

    public void setOrderRead(boolean orderRead) {
        this.orderRead = orderRead;
    }

}