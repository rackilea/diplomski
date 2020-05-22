import java.awt.*;
import javax.swing.*;

import javax.swing.border.TitledBorder;

class AmortizationLayout {

    AmortizationLayout() {
        JPanel gui = new JPanel(new BorderLayout(2,2));

        JPanel labelFields = new JPanel(new BorderLayout(2,2));
        labelFields.setBorder(new TitledBorder("BorderLayout"));

        JPanel labels = new JPanel(new GridLayout(0,1,1,1));
        labels.setBorder(new TitledBorder("GridLayout"));
        JPanel fields = new JPanel(new GridLayout(0,1,1,1));
        fields.setBorder(new TitledBorder("GridLayout"));

        for (int ii=1; ii<4; ii++) {
            labels.add(new JLabel("Label " + ii));
            // if these were of different size, it would be necessary to
            // constrain them using another panel
            fields.add(new JTextField(10));
        }

        labelFields.add(labels, BorderLayout.CENTER);
        labelFields.add(fields, BorderLayout.EAST);

        JPanel guiCenter = new JPanel(new BorderLayout(2,2));
        guiCenter.setBorder(new TitledBorder("BorderLayout"));
        JPanel buttonConstrain = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonConstrain.setBorder(new TitledBorder("FlowLayout"));
        buttonConstrain.add( new JButton("Click Me") );
        guiCenter.add( buttonConstrain, BorderLayout.NORTH );

        guiCenter.add(new JScrollPane(new JTextArea(5,30)));

        gui.add(labelFields, BorderLayout.NORTH);
        gui.add(guiCenter, BorderLayout.CENTER);

        JOptionPane.showMessageDialog(null, gui);
    }

    public static void main(String[] args) throws Exception {
        //Create the GUI on the event dispatching thread
        SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                new AmortizationLayout();
            }
        });
    }
}