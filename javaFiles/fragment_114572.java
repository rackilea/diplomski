package com.quaternion.struts2basic.action.test;

import com.opensymphony.xwork2.ActionSupport;
import java.util.HashMap;
import java.util.Map;

public class Test extends ActionSupport{
    //public to make example shorter
    public Map<Integer, String> myMap = new HashMap<Integer, String>();

    public String exectute(){
        return SUCCESS;
    }
}