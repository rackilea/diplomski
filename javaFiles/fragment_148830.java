package com.example.xml.adaptor;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class BooleanToEmptyObjectAdapter extends XmlAdapter<EmptyObject, Boolean> {
    @Override
    public EmptyObject marshal(final Boolean v) {
        return v != null && v ? new EmptyObject() : null;
    }

    @Override
    public Boolean unmarshal(final EmptyObject v) {
        return true;
    }
}