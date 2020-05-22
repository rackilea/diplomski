package com.java.stackoverflow;

public class Teacher {

    private int tea_id;
    private String name;
    Score Score;

    public Teacher(int tea_id, String name) {
        this.name = name;
        this.tea_id = tea_id;
        Score = new Score();
    }

    public void input(float num, int course) {
    }

    public void input(float[] score) {
    }

    public void check() {
    }

    public float getSum() {
        return Score.sum;
    }

    public float getAverage() {
        return Score.average;
    }

    public int getTea_id() {
        return tea_id;
    }

    public void setTea_id(int tea_id) {
        this.tea_id = tea_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}