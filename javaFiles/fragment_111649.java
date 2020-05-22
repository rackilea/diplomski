public class OrderItem {

private String vegetable;
private int[] array;
private int cost;

public void set(String veg,int[] arr,int cos){
    this.vegetable=veg;
    this.array=arr;
    this.cost=cos;
}

public String getVeg(){
    return this.vegetable;
}