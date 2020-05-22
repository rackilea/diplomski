import java.util.ArrayList;
/**
 * 
 * @author manish
 *
 */

public class CustomArrayList {

    public static void main(String args[]){
        ArrayList<reciept> custReciept=new ArrayList<reciept>();
        custReciept.add(new reciept("Book", 12.55, true, false));
        custReciept.add(new reciept("Book2", 15.55, true, true));

        for(int i=0;i<custReciept.size();i++){
    System.out.println( custReciept.get(i).name);
    System.out.println( custReciept.get(i).price);
    System.out.println( custReciept.get(i).first);

    }

    }


}
class reciept{
    String name;
    double price;
    boolean first,second;

    public reciept(String name, double price, boolean first, boolean second) {
        super();
        this.name = name;
        this.price = price;
        this.first = first;
        this.second = second;
    }

}