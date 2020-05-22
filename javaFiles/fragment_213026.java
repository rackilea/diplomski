import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Parent {
    String phone_vendor;int price,ram,storage;

    public Parent(String phone_vendor, int price, int ram, int storage) {
        this.phone_vendor = phone_vendor;
        this.price = price;
        this.ram = ram;
        this.storage = storage;
    }

    public static void main(String[] args) {
        Universal us = new Universal("Samsung", 51, 5, 11);
        Showroom sr = new Showroom("Nokia", 50, 4, 10);

        List<Parent> lst = new ArrayList<Parent>();
        lst.add(us);
        lst.add(sr);
        Collections.sort(lst, new PriceComparator());

        for(Parent p:lst) {
            System.out.println(p.price);
        }

    }
}


class Showroom extends Parent {

    public Showroom(String phone_vendor, int price, int ram, int storage) {
        super(phone_vendor, price, ram, storage);
    }

}
class Universal extends Parent {
   public Universal(String phone_vendor, int price, int ram, int storage) {
       super(phone_vendor, price, ram, storage);
   }
}

class PriceComparator implements Comparator<Parent> {
    @Override
    public int compare(Parent o1, Parent o2) {
        return o1.price - o2.price;
    }
}