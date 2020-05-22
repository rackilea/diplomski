import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class FlightBooker extends JFrame implements ActionListener {
    FlightBooker() {
        super("Book a Flight!");
        JLabel fromLabel = new JLabel("Current Location:");
        JComboBox fromLocations = new JComboBox();
        fromLocations.addItem("Paris");
        //fromLocations.addItem(someLocation);
        //...
        JLabel toLabel = new JLabel("Destination:");
        JComboBox destinations = new JComboBox();
        destinations.addItem("Belfast");
        //destinations.addItem(someLocation);
        //...
        JButton okButton = new JButton("OK");
        JLabel status = new JLabel("");
        add(fromLabel);
        add(fromLocations);
        add(toLabel);
        add(destinations);
        okButton.addActionListener(this);
        add(okButton);
        add(status);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    public void actionPerformed(ActionEvent event) {
        Object from = fromLocations.getSelectedItem();
        String FROM = from.toString();
        Object to = destinations.getSelectedItem();
        String TO = to.toString();
        status.setText("You're flying from " + FROM + "to " + TO + ".");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() { new FlightBooker().setVisible(true); }
        });
    }
}