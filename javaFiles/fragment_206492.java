package com.asynctask.namespace;
import java.util.ArrayList;

public class User
{   
    // initialize before use
    private ArrayList<String> name = new ArrayList<String>();

    public void addName(String value)
    {       
        name.add(value);
    }

    public String getName(int pos)
    {       
        return name.get(pos).toString();
    }
}