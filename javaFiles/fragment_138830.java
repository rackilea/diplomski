package com.spinner.jackson;

import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

@JsonSerialize(using = CustomDeserial.class)
public class ClientObject {

    @JacksonXmlElementWrapper(useWrapping = false)
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
    private List<MyItem> accounts;

    public ClientObject(List<MyItem> pl) {
        this.accounts = pl;
    }

    public ClientObject() {
        this.accounts = new ArrayList<MyItem>();
    }

    public void setL(List<MyItem> l) {
        this.accounts = l;
    }

    public List<MyItem> getAccounts() {
        return this.accounts;
    }
}