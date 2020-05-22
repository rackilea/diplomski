package com.example;

import javafx.beans.NamedArg;

public class Animal {

    private final String name;
    private boolean housePet;

    public Animal(@NamedArg("name") String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean isHousePet() {
        return housePet;
    }

    public void setHousePet(boolean housePet) {
        this.housePet = housePet;
    }

    @Override
    public String toString() {
        return "Animal[name=" + name + ", housePet=" + housePet + "]";
    }

}