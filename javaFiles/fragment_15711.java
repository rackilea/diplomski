import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ExampleFrame extends JFrame {

    private JButton add, remove;
    private JPanel dynamicButtonPane, addRemovePane;

    private boolean waitingForLocationClick;

    public ExampleFrame() {
        super("Dynamic button example");
        waitingForLocationClick = false;
        add = new JButton("Add Button");
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addButton(JOptionPane
                        .showInputDialog("Name of the new button:"));
            }
        });
        remove = new JButton("Remove Button");
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lookingToRemove = true;
            }
        });
        JPanel mainPane = new JPanel(new BorderLayout());
        dynamicButtonPane = new JPanel();
        dynamicButtonPane.setLayout(null);
        dynamicButtonPane.setPreferredSize(new Dimension(300, 300));
        addRemovePane = new JPanel();
        addRemovePane.add(add);
        addRemovePane.add(remove);
        mainPane.add(dynamicButtonPane, BorderLayout.NORTH);
        mainPane.add(addRemovePane, BorderLayout.SOUTH);
        add(mainPane);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        dynamicButtonPane.addMouseListener(pointSelectorListener);
    }

    private JButton buttonToPlace;

    public void addButton(String name) {
        JButton b = new JButton(name);
        b.setActionCommand(name);
        b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (lookingToRemove) {
                    if (e.getSource() instanceof JButton) {
                        dynamicButtonPane.remove((Component) e.getSource());
                        dynamicButtonPane.validate();
                        dynamicButtonPane.repaint();
                    }
                } else
                    JOptionPane.showMessageDialog(ExampleFrame.this, "This is " + e.getActionCommand());
            }
        });
        waitingForLocationClick = true;
        lookingToRemove = false;
        buttonToPlace = b;
    }

    public void putButtonAtPoint(Point p) {
        System.out.println("Placing a button at: " + p.toString());
        dynamicButtonPane.add(buttonToPlace);
        buttonToPlace.setBounds(new Rectangle(p, buttonToPlace
                .getPreferredSize()));
        dynamicButtonPane.validate();
        buttonToPlace = null;
        waitingForLocationClick = false;
    }

    private boolean lookingToRemove = false;

    private final MouseListener pointSelectorListener = new MouseAdapter() {
        @Override
        public void mouseClicked(MouseEvent e) {
            if (waitingForLocationClick) {
                putButtonAtPoint(e.getPoint());
            } else {
                System.out.println("Not in waiting state");
            }
        }
    };

    public static void main(String[] args) {
        new ExampleFrame();
    }
}