package com.massaiolir.simple.iface;

import org.simpleframework.xml.Element;

public class BaseObject implements Error {
    @Element(name = "Err", required = false, type = ConcreteError.class)
    private Error err;

    @Override
    public String getErrorText() {
        return err.getErrorText();
    }

    @Override
    public void setErrorText(String errorText) {
        err.setErrorText(errorText);
    }
}