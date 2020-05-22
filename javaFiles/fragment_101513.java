package com.massaiolir.simple.iface;

import org.simpleframework.xml.Attribute;

public class ConcreteError implements Error {
    @Attribute
    private String text;

    @Override
    public String getErrorText() {
        return text;
    }

    @Override
    public void setErrorText(String errorText) {
        this.text = errorText;
    }

}