package scrap;

public class FoodList {

private String Vegetable;
private String meat;
private String liquid;
private String other;

public FoodList() {
    //default constructor
}

public String getVegetable() {
    return Vegetable;
}
public void setVegetable(String vegetable) {
    Vegetable = vegetable;
}
public String getMeat() {
    return meat;
}
public void setMeat(String meat) {
    this.meat = meat;
}
public String getLiquid() {
    return liquid;
}
public void setLiquid(String liquid) {
    this.liquid = liquid;
}
public String getOther() {
    return other;
}
public void setOther(String other) {
    this.other = other;
}