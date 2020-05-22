package com.company;

import java.util.Date;
import com.othercompany.YetAnotherClass;

public class MyObject {

    private YetAnotherClass other;
    public MyObject(String first, String last, String city) {
        this.other = new YetAnotherClass();
    }

    public String execute() {
        return "Method execute invoked at "+ new Date();
    }
}