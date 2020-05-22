package com.example;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = -7240509760819729807L;

    private String userId;
    private String password;

    public User() {
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}