import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

public class Example extends JFrame{

    private JComboBox<String> comboBox;
    private JList<String> list;
    private DefaultListModel<String> model;

    Example(){
            comboBox = new JComboBox<>(new String[]{"111","222","333"});
            list = new JList<>(model = new DefaultListModel<>());
            add(comboBox,BorderLayout.SOUTH);
            add(new JScrollPane(list));

            addKeyBindings((JComponent) getContentPane());
            addKeyBindings(comboBox);

            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            pack();
            setVisible(true);
    }

    private void addKeyBindings(JComponent c) {
        c.getInputMap(JComboBox.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(KeyStroke.getKeyStroke("ENTER"), "doSomething");
        c.getActionMap().put("doSomething", new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Object selectedItem = comboBox.getSelectedItem();
                if(selectedItem != null){
                    model.addElement((String)selectedItem);
                }
            }
        });
    }

    public static void main(String[] args) {
         new Example();
    }

}