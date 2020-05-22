package tests;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

public class CustomLabel extends Label{

    public CustomLabel() {
        setAlignment(Pos.CENTER);
        setPrefSize(50, 25);
    }

    void setTextAndId(String s){
        super.setText(s);
        /*To keep this demo simple and clear id is changed.
          If used, care must be taken to keep id unique. 
          Using setStyle() or PseudoClass should be preferred 
        */
        setId(s); 
    }
}