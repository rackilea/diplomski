package com.ggl.layout.view;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.ggl.layout.model.LayoutModel;

public class TextPanel {

    private JScrollPane scrollPane;

    private JTextArea textArea;

    private LayoutModel model;

    public TextPanel(LayoutModel model) {
        this.model = model;
        createPartControl();
    }

    private void createPartControl() {
        textArea = new JTextArea(10, 60);
        textArea.setDocument(model.getDocument());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        scrollPane = new JScrollPane(textArea);
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JTextArea getTextArea() {
        return textArea;
    }

}