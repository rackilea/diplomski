package com.dominikangerer.q29550820;

public class Person {
    private String name;

    private String lastName;

    @SerializedName("clothes")
    private Map<String, Object> clothesWrapper;

    public String getGender() {
        return clothesWrapper.get("gender").toString();
    }

    public void setGender(String gender) {
        this.clothesWrapper.put("gender", gender);
    }
}