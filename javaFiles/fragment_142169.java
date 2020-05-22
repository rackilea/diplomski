import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class ArrayListSortingExample {
   private static class SmartPhone implements Comparable<SmartPhone> {
    private String brand;
    private String model;
    private int price;
    public SmartPhone(String brand, String model, int price){
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    @Override
    public int compareTo(SmartPhone sp) {
        return this.brand.compareTo(sp.brand);
    }
    @Override
    public String toString() {
        return "SmartPhone{" + "brand=" + brand + ", model=" + model + ", price=" + price + '}';
    }
}
private static class PriceComparator implements Comparator<SmartPhone> {
    @Override
    public int compare(SmartPhone sp1, SmartPhone sp2) {
        return (sp1.price < sp2.price ) ? -1: (sp1.price > sp2.price) ? 1:0 ;
    }
}
public static void main(String... args) {
    SmartPhone apple = new SmartPhone("Apple", "IPhone4S",1000);
    SmartPhone nokia = new SmartPhone("Nokia", "Lumia 800",600);
    SmartPhone samsung = new SmartPhone("Samsung", "Galaxy Ace",800);
    SmartPhone lg = new SmartPhone("LG", "Optimus",500);
    ArrayList<SmartPhone> Phones = new ArrayList<SmartPhone>();
    Phones.add(apple);
    Phones.add(nokia);
    Phones.add(samsung);
    Phones.add(lg);
    Collections.sort(Phones);
    System.out.println(Phones);
    Collections.sort(Phones, new PriceComparator());
    System.out.println(Phones);
}
}