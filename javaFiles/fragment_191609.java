package backingbeans;

import javax.faces.model.*;
import javax.faces.event.*;

public class MyBackingBean {

    private String prop1 = "";

    public MyBackingBean() {
    }

    //<editor-fold defaultstate="collapsed" desc="Properties">
    public String getProp1() {
        return this.prop1;
    }

    public void setProp1(String prop1) {
        this.prop1 = prop1;
    }
   //</editor-fold>


   //<editor-fold defaultstate="collapsed" desc="Action listeners">
    public void myFirstListener(ActionEvent event) {
        ... do something ...
    }

   public void mySecondListener(ActionEvent event) {
        ... do something else ...
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Action handlers">
    public String myFirstActionHandler() {
        ... do something ...
        return "OUTCOME1";
    }

    public String mySecondActionHandler() {
        ... do something else ...
        return "OUTCOME2";
    }
    //</editor-fold>
}