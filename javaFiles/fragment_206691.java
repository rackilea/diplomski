package com.test.dozer;

import com.extjs.gxt.ui.client.data.BaseModelData;

public class Class1 extends BaseModelData {

    // Notice the return type here: "Integer" and *not* int
    // Returning int throws a NullPointerException when get("id") is null!
    public Integer getId() {
        return (Integer) get("id");
    }

    public void setId(Integer id) {
        set("id", id);
    }

}