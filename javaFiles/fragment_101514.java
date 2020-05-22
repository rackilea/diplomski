package com.massaiolir.simple.iface;

import java.util.ArrayList;

import org.simpleframework.xml.ElementList;

public class ConList extends BaseObject {
    @ElementList(entry = "Con", inline = true)
    public ArrayList<Con> cons;
}