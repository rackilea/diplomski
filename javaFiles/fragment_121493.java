package com.test;

public class Product {
    private String product;
    private String company;
    private String CName;
    private String validity;
    private String unit;
    private String totPrice;

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String cName) {
        CName = cName;
    }

    public String getValidity() {
        return validity;
    }

    public void setValidity(String validity) {
        this.validity = validity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getTotPrice() {
        return totPrice;
    }

    public void setTotPrice(String totPrice) {
        this.totPrice = totPrice;
    }

    @Override
    public String toString() {
        return "Product [product=" + product + ", company=" + company + ", CName=" + CName + ", validity=" + validity
                + ", unit=" + unit + ", totPrice=" + totPrice + "]";
    }

}