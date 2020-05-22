package com.mycompany.yetanothercheckbox;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 *
 * @author returncode13
 */
public class C {
    BooleanProperty checkUncheck=new SimpleBooleanProperty();
    BooleanProperty indeterminate=new SimpleBooleanProperty();

    public BooleanProperty getCheckUncheck() {
        return checkUncheck;
    }

    public void setCheckUncheck(BooleanProperty checkUncheck) {
        this.checkUncheck = checkUncheck;
    }

    public BooleanProperty getIndeterminate() {
        return indeterminate;
    }

    public void setIndeterminate(BooleanProperty indeterminate) {
        this.indeterminate = indeterminate;
    }

    public BooleanProperty checkUncheckProperty(){
        return checkUncheck;
    }

    public BooleanProperty indeterminateProperty(){
        return indeterminate;
    }
}