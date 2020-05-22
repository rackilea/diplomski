import java.awt.BorderLayout;
import java.io.IOException;
import java.text.NumberFormat;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Test {

    enum Item {
        PEARS(100.0),
        APPLES(25.0),
        ICECREAME(225.30);

        private double price;

        private Item(double price) {        
            this.price = price;
        }

        public double getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return name();
        }

    }

    public static void main(String[] args) throws IOException {
        new Test();
    }

    public Test() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JLabel tally = new JLabel("0");
                DefaultListModel<Item> model = new DefaultListModel<>();
                model.addElement(Item.PEARS);
                model.addElement(Item.APPLES);
                model.addElement(Item.ICECREAME);
                JList<Item> listOfItems = new JList<>(model);
                listOfItems.addListSelectionListener(new ListSelectionListener() {
                    @Override
                    public void valueChanged(ListSelectionEvent e) {
                        if (e.getValueIsAdjusting()) {
                            return;
                        }
                        double price = 0;
                        for (Item item : listOfItems.getSelectedValuesList()) {
                            price += item.getPrice();
                        }
                        tally.setText(NumberFormat.getCurrencyInstance().format(price));
                    }
                });

                JFrame frame = new JFrame("Test");
                frame.add(new JScrollPane(listOfItems));
                frame.add(tally, BorderLayout.SOUTH);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true); 
            }
        });
    }

}