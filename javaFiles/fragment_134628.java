package com.mypackage.test;

import org.mule.api.annotations.param.Payload;

    public class MyComponent {

    private String myProperty;

    public String getMyProperty() {
        return myProperty;
    }

    public void setMyProperty(String myProperty) {
        this.myProperty = myProperty;
    }

    public String doProcess(@Payload String payload) {
        //do something interesting
        return "You said: " + payload;
    }

}