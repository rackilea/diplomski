package com.example;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MetaDatum {

    ...

    @SerializedName("value")
    @Expose
    private Object value;

    ...

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

}