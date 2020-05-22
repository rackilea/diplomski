package com.example;

public class SpecialUser extends User {
    private static final long serialVersionUID = 101162430966683621L;

    private String firstName;

    public SpecialUser() {
        super();
    }

    public String getFirstName() {
        return this.firstName;
    }
}