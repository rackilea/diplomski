package com.example;

import javax.faces.convert.EnumConverter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value="severityConverter")
public class SeverityConverter extends EnumConverter {

    public SeverityConverter() {
        super(Severity.class);
    }

}