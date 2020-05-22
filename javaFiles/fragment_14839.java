package com.example;

import javafx.scene.control.Button;
import javafx.scene.control.Skin;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

// DO NOT DO THIS - com.sun is not public!
// (However, it seems that there is currently no alternative besides duplicating the code)
// With Java 9, change to javafx.scene.control.skin.ButtonSkin
class QButtonSkin extends com.sun.javafx.scene.control.skin.ButtonSkin {

    private Rectangle rect = null;

    public QButtonSkin(Button button) {
        super(button);
    }

    @Override
    protected void updateChildren() {
        super.updateChildren();

        if (rect == null) {
            rect = new Rectangle(0., 0., 200., 200.);
            rect.setStroke(Color.RED);
            rect.setFill(Color.TRANSPARENT);
            rect.setStrokeWidth(2);
        }
        getChildren().add(rect);
    }
}

public class QButton extends Button {
    public QButton(String str) {
        super(str);
    }

    @Override
    protected Skin<?> createDefaultSkin() {
        Skin<?> result = new QButtonSkin(this);
        return result;
    }
}