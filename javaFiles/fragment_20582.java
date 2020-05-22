package com.test.package;

import java.awt.Color;
import javax.swing.DefaultListModel;
import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author rmu
 */
public class ChatDemo extends JFrame {

    private final JScrollPane scrollPaneMessages;
    private final JList<String> listMessages = new JList<String>();
    private final JPanel pnlUsers = new JPanel();
    private final JTextField txtUserMsgInput = new JTextField();

    public ChatDemo() {
        scrollPaneMessages = new JScrollPane(listMessages);
        pnlUsers.setBackground(Color.WHITE);
        setVisible(true);
        setTitle("Chat layout demo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        putSampleData();
        organizeLayout();
    }

    private void organizeLayout() {
        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addComponent(scrollPaneMessages, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, Short.MAX_VALUE)
                        .addComponent(pnlUsers, 50, 50, 50))
                .addComponent(txtUserMsgInput)
        );
        layout.setVerticalGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(scrollPaneMessages)
                        .addComponent(pnlUsers))
                .addComponent(txtUserMsgInput, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        pack();

    }

    private void putSampleData() {
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addElement("Very long string with many characters... Oh, so long!!");
        listModel.addElement("This string is shorter");
        listMessages.setModel(listModel);
    }

    public static void main(String[] args) {
        new ChatDemo();
    }
}