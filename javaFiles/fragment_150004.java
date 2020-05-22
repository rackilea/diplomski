package com.learning.springbootapp;

import java.util.List;

public class MyPojo {
    private String name;
    private Long salary;
    private List<AddressLocation> addressLocations;

    // getters and setters
}

class AddressLocation {
    private String line1;
    private String line2;

    // getters and setters
}