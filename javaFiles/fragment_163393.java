package com.ggl.layout.model;

import java.awt.Dimension;

import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;

public class LayoutModel {

    private Document document;

    private String textString;

    public LayoutModel() {
        document = new DefaultStyledDocument();
    }

    public Dimension getPreferredSize() {
        return new Dimension(300, 200);
    }

    public Document getDocument() {
        return document;
    }

    public String getTextString() {
        return textString;
    }

    public void setTextString(String textString) {
        this.textString = textString;
    }

}