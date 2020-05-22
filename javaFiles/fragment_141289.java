package com.mycompany.yetanothercheckbox;

import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author returncode13
 */
public class B extends A{
    private StringProperty name=new SimpleStringProperty();
    C Check=new C();
    final boolean isLeaf=true;
    final boolean isParent=false;
     public boolean updateParent=false;
    public boolean updateChildren=false;
    A parent;

    public A getParent() {
        return parent;
    }

    public void setParent(A parent) {
        this.parent = parent;
    }


    @Override
    public boolean isLeaf() {
        return isLeaf;
    }

    @Override
    public boolean isParent() {
        return isParent;
    }



    @Override
    public StringProperty getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name.set(name);
    }

    @Override
    public C getCheck() {
        return Check;
    }

    @Override
    public void setCheck(C Check) {
        this.Check = Check;
    }

    @Override
     public StringProperty nameProperty(){
        return name;
    }

    @Override
       public List<A> getChildren() {
        return parent.getChildren();
    }

}