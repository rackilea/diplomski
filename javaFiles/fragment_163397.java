package com.ggl.layout.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.ggl.layout.model.LayoutModel;

public class ControlPanel {

    private JButton submitButton;

    private JPanel panel;

    private JTextField textField;

    private LayoutModel model;

    public ControlPanel(LayoutModel model) {
        this.model = model;
        createPartControl();
    }

    private void createPartControl() {
        panel = new JPanel();
        panel.setLayout(new BorderLayout());

        textField = new JTextField(20);
        panel.add(textField, BorderLayout.CENTER);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new SubmitActionListener());
        panel.add(submitButton, BorderLayout.EAST);
    }

    public JButton getSubmitButton() {
        return submitButton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public class SubmitActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            // TODO Auto-generated method stub
            model.setTextString(textField.getText().trim());
        }

    }

}