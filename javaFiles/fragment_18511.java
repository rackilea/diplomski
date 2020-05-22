package com.ggl.drawing;

import java.awt.Point;

public class GUIModel {

    private String displayString;

    private Point coordinate;

    public GUIModel(String displayString) {
        this.displayString = displayString;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(int x, int y) {
        this.coordinate = new Point(x, y);
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public void setDisplayString(String displayString) {
        this.displayString = displayString;
    }

    public String getDisplayString() {
        return displayString;
    }

}