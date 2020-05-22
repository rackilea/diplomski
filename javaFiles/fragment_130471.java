import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

public class InitGraphics {
    @SuppressWarnings("serial")
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            final DefaultListModel<Order> orderModel = new DefaultListModel<>();
            orderModel.addElement(new Order("One"));
            orderModel.addElement(new Order("Two"));
            orderModel.addElement(new Order("Three"));
            orderModel.addElement(new Order("Four"));
            orderModel.addElement(new Order("Five"));

            final JList<Order> orderList = new JList<>(orderModel);
            orderList.setCellRenderer(new CookListCellRender());
            orderList.setVisibleRowCount(5);

            JPanel panel = new JPanel();
            // panel.setLayout(new BoxLayout(panel, BoxLayout.LINE_AXIS));
            panel.add(new JScrollPane(orderList));

            panel.add(new JButton(new AbstractAction("Read") {

                @Override
                public void actionPerformed(ActionEvent e) {
                    List<Order> selectedOrders = orderList.getSelectedValuesList();
                    for (Order order : selectedOrders) {
                        order.setOrderRead(true);
                    }
                    orderList.repaint();
                }
            }));
            panel.add(new JButton(new AbstractAction("Done") {

                @Override
                public void actionPerformed(ActionEvent e) {
                    List<Order> selectedOrders = orderList.getSelectedValuesList();
                    for (Order order : selectedOrders) {
                        order.setOrderDone(true);
                    }
                    orderList.repaint();
                }
            }));
            panel.add(new JButton(new AbstractAction("Clear") {

                @Override
                public void actionPerformed(ActionEvent e) {

                    for (int i = 0; i < orderModel.size(); i++) {
                        orderModel.getElementAt(i).setOrderDone(false);
                        orderModel.getElementAt(i).setOrderRead(false);
                    }
                    orderList.repaint();
                }
            }));


            JFrame frame = new JFrame("Test List");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(panel);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

@SuppressWarnings("serial")
class CookListCellRender extends JLabel implements ListCellRenderer<Order> {

    public CookListCellRender() {
        setOpaque(true);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends Order> list, Order value, int index,
            boolean isSelected, boolean cellHasFocus) {

        // setOpaque(true); // !! 

        // !! setLayout(new FlowLayout());
        setText(value.getNameEl());
        // !! list.setVisibleRowCount(30);
        // !! list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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