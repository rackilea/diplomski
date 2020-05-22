package com.mycompany.yetanothercheckbox;

import java.util.Iterator;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author returncode13
 */
public class A {
    private StringProperty name=new SimpleStringProperty();
    C check=new C();
    List<A> children;
    final boolean isLeaf=false;
    final boolean isParent=true;
    public boolean updateParent=false;
    public boolean updateChildren=false;
    public boolean isLeaf() {
        return isLeaf;
    }

    public boolean isParent() {
        return isParent;
    }
    public StringProperty getName() {
        return name;
    }

     public void setName(String name) {
        this.name.set(name);
    }

    public C getCheck() {
        return check;
    }

    public void setCheck(C check) {
        this.check = check;
        for (Iterator<A> iterator = children.iterator(); iterator.hasNext();) {
            A next = iterator.next();
            next.setCheck(check);

        }
    }

    public StringProperty nameProperty(){
        return name;
    }

    public List<A> getChildren() {
        return children;
    }

    public void setChildren(List<A> children) {
        this.children = children;
    }

    public A getParent() {
        return this;
    }
}