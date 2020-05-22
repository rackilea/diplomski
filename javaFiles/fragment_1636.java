package com.example.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ListExample {
    static List<String> strlist = new ArrayList<String>();

    public static void main(String[] args) {
        List<String> strlisttemp = new ArrayList<String>();
        strlisttemp.add("a");
        strlisttemp.add("b");
        strlisttemp.add("c");

        final JList list = new JList(strlisttemp.toArray());
        list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

        final ListSelectionListener listSelectionListener = new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent e) {

                strlist = list.getSelectedValuesList(); // use this instead

//              String lstr = list.getSelectedValuesList().toString();
//              strlist = Arrays.asList(lstr.split("\\s*,\\s*"));

                System.out.println(strlist);
            }
        };

        list.addListSelectionListener(listSelectionListener);
        JOptionPane.showMessageDialog(null, list, "Select", JOptionPane.QUESTION_MESSAGE);


    }
}