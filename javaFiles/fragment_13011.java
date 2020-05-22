package com.fabrikam.functions;

import com.microsoft.azure.storage.table.TableServiceEntity;

public class myEntity extends TableServiceEntity {

    public String m_prop1 = "";
    public String m_newProp = "";
    public String m_newProp1 = "";

    public String name = "";
    public String oldProp = "";

    public myEntity(String lastName, String firstName) {
        this.partitionKey = lastName;
        this.rowKey = firstName;
    }

    public void setProp1(String prop1) {
        m_prop1 = prop1;
    }

    public String getProp1() {
        return m_prop1;
    }


    public String getNewProp(String newProp) {
        return m_newProp;
    }

    public String getNewProp1(String newProp1) {
        return m_newProp1;
    }


    public void setNewProp(String newProp) {
        m_newProp = newProp;
    }

    public void setNewProp1(String newProp1) {
        m_newProp1 = newProp1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOldProp() {
        return oldProp;
    }

    public void setOldProp(String oldProp) {
        this.oldProp = oldProp;
    }
}