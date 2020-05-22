import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class FrameTest {

    public static void main(String[] args) {
        JFrame f = new JFrame("Frame Test");


        ArrayList<String> str = new ArrayList<String>();
        for (int i = 0; i < 20; i++)
            str.add("number " + i);

        JTextPane tp = new JTextPane();


        int visibleRowCount = str.size();
        System.out.println("visibleRowCount " + visibleRowCount);
        JList listForSuggestion = new JList(str.toArray());
        listForSuggestion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listForSuggestion.setSelectedIndex(0);
        listForSuggestion.setVisibleRowCount(5);
        System.out.println(listForSuggestion.getVisibleRowCount());
        JScrollPane listScrollPane = new JScrollPane(listForSuggestion);
        MouseListener mouseListener = new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                JList theList = (JList) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2) {
                    int index = theList.locationToIndex(mouseEvent.getPoint());
                    if (index >= 0) {
                        Object o = theList.getModel().getElementAt(index);
                        System.out.println("Double-clicked on: " + o.toString());
                    }
                }
            }
        };
        listForSuggestion.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
        listForSuggestion.addMouseListener(mouseListener);
        Dimension dim = listForSuggestion.getPreferredSize();
        listForSuggestion.setBounds(20, 20, (int) dim.getWidth(), (int) dim.getHeight());

        tp.add(listForSuggestion);

        f.add(tp);
        f.setSize(400, 400);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);

    }
}