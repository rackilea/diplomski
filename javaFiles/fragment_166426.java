package com.school;

public enum Status {

    FULL_TIME("F"),
    PART_TIME("P");

    private final String code;

    Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

}