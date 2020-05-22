package com.ggl.jlisttest;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class JListTest implements Runnable {

    private JListModel listModel;

    private JFrame frame;

    private JList<String> wordList;

    private JTextField searchField;

    public JListTest() {
        this.listModel = new JListModel();
    }

    @Override
    public void run() {
        frame = new JFrame("JList Test");
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                exitProcedure();
            }
        });

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        searchField = new JTextField(20);
        searchField.addKeyListener(new PrefixListener());
        mainPanel.add(searchField, BorderLayout.NORTH);

        wordList = new JList<String>(listModel.getListModel(""));
        JScrollPane scrollPane = new JScrollPane(wordList);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public void exitProcedure() {
        frame.dispose();
        System.exit(0);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new JListTest());
    }

    public class PrefixListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
            String prefix = searchField.getText() + e.getKeyChar();
            wordList.setModel(listModel.getListModel(prefix.trim()));
        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }
}