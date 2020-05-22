package com.example.widgets // Make this package whatever you want

import com.google.gwt.user.client.ui.Composite

public class FirstPanel extends Composite{

    private VerticalPanel verticalPanel;

    public FirstPanel(){

        verticalPanel = new VerticalPanel();

        // All composites must call initWidget() in their constructors.
        initWidget(verticalPanel);

        // For your CSS
        setStyleName("example-SomeStyle");

        // Continue constructing object ...
    }

}